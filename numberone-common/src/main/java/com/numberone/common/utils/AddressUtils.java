package com.numberone.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.numberone.common.config.Global;
import com.numberone.common.json.JSON;
import com.numberone.common.json.JSONObject;
import com.numberone.common.utils.http.HttpUtils;

/**
 * 获取地址类
 * 
 * @author numberone
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip)
    {
        String address = "XX XX";

        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "內網IP";
        }
        if (Global.isAddressEnabled())
        {
            String rspStr = HttpUtils.sendPost(IP_URL, "ip=" + ip);
            if (StringUtils.isEmpty(rspStr))
            {
                log.error("獲取地理位置異常{}", ip);
                return address;
            }
            JSONObject obj;
            try
            {
                obj = JSON.unmarshal(rspStr, JSONObject.class);
                JSONObject data = obj.getObj("data");
                String region = data.getStr("region");
                String city = data.getStr("city");
                address = region + " " + city;
            }
            catch (Exception e)
            {
                log.error("獲取地理位置異常 {}", ip);
            }
        }
        return address;
    }
}