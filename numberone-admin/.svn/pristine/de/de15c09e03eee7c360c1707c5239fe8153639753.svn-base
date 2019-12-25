
$(function() {
    validateRule();
	$('.imgcode').click(function() {
		var url = ctx + "captcha/captchaImage?type=" + captchaType + "&s=" + Math.random();
		$(".imgcode").attr("src", url);
	});
});

$.validator.setDefaults({
    submitHandler: function() {
		login();
    }
});

function login() {
	$.modal.loading($("#btnSubmit").data("loading"));
	var username = $.common.trim($("input[name='username']").val());
    var password = $.common.trim($("input[name='password']").val());
    var validateCode = $("input[name='validateCode']").val();
    var rememberMe = $("input[name='rememberme']").is(':checked');
    $.ajax({
        type: "post",
        url: ctx + "login",
        data: {
            "username": username,
            "password": password,
            "validateCode" : validateCode,
            "rememberMe": rememberMe
        },
        success: function(r) {
            if (r.code == 0) {
                location.href = ctx + 'index';
            } else {
            	$.modal.closeLoading();
            	$('.imgcode').click();
            	$(".code").val("");
            	$.modal.msg(r.msg);
            }
        }
    });
}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            }
        },
        messages: {
            username: {
                required: icon + "请输入您的用户名",
            },
            password: {
                required: icon + "请输入您的密码",
            }
        }
    })
}

function addFavorite() {
	var url = window.location;
	var title = document.title;
	
    try {
        window.external.addFavorite(url, title);
    } catch (e) {
        try {
            window.sidebar.addPanel(title, url, "");
        } catch (e) {
            alert("加入收藏失败，请使用Ctrl+D进行添加");
        }
    }
}

function addFavoriteNew(){
	        var url = window.location;
	        var title = document.title;
	        var ua = navigator.userAgent.toLowerCase();
	        if (ua.indexOf("360se") > -1) {
	            alert("由于360浏览器功能限制，请按 Ctrl+D 手动收藏！");
	        }else if (ua.indexOf("msie 8") > -1) {             window.external.AddToFavoritesBar(url, title); //IE8
	        }else if (document.all) {//IE类浏览器
	            try{
	                window.external.addFavorite(url, title);
	            }catch(e){
	                alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
	            }
	        }else if (window.sidebar) {//firfox等浏览器；             window.sidebar.addPanel(title, url, "");
	        }else {
	            alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
	        }
}

//走马灯通知效果
function scrollMessage(){
	//url , data-返回数据
		$.get("/ajaxControlAction_loginCaption.do",function (data){
			var d = $("#marquee_id");
			if(d.length==0){
				d = $("<marquee id='marquee_id' direction='left' behavior='scroll' scrollamount='5'></marquee>");
				d.mouseover(function(){this.stop();});
				d.mouseout(function(){this.start();});
				$(".login_marquee").append(d);
			}
			//重新设置数据
			d.html(data);
		});
}