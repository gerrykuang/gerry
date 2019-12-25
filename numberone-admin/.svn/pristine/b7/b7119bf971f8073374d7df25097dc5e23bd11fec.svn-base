
/** 
	书写一个配置，然后调用一次simpleSmartTip()函数，配置做参数传递给函数
	
   //这是配置说明
     var config = {
	    el: null,    //[必需] 监听的输入框元素（监听value属性）,dom对象或选择器
	    data: [],    //[必需] 提示的信息
	    size: 10,    //[必需] 信息最多显示多少个
	    showContainer: null,  //可选，使用dom元素或者选择器。展示内容的父标签，如果不设置，则会自己在父元素末尾创建一个div（dom对象）。
	    containerStyle: null, //容器的樣式
	    divStyle: null,   //提示的 div的样式，不能写类
	    divHoverStyle: null, // 鼠標放上去的樣式
	    
	    //提示出现之前要执行的函数。（可用于 向服务器请求获取数据，然后更新data的值，注意不要用异步请求)
	    //text是绑定的元素（input，有value属性的都行）的value属性）
	    //数据更新后，一定要调用 callback 函数，更新显示
  	    beforeShow: function(text,callback){ 
  	    	//TO DO...Data Update..
  	    	callback(config);
  	    },  
  	    //單擊div的事件，el是被单击的元素（dom对象），返回值： true-关闭提示，false-不关闭提示
	    clickHandler: function(el){  return true;} 
     };

*/	
/* 示例	
  <div style="width: 500px;height: 400px; position: absolute;top:0px;right:0px;bottom: 0px;left: 0px;margin:auto;background:#acacac;">
      <div>
        <input id="smartInput" style="height:80px;width:300px;font-size: 22px;padding: 4px;margin: 0px 100px;" value="2333" />
      </div>
        <div style="background: red;height:60px;">
		</div>
		<div style="background: blue;height:60px;">
		</div>   
		<div style="background: green;height:60px;">
		</div>   
   </div>
     
    //下面是配置示例
	测试部分，展示中 li 里面只有简单的文本，不含有其他的元素
	var materialConfig = {
		el: "#smartInput",
		data: ["a1", "a2", "bcc", "input", "bbs", "wistron", "book", "annie", "Anna"],
		size: 10,
		showContainer: null,
		containerStyle: "background:#c4c5d0;margin: 0px 100px;width:300px",
		divStyle: "padding:4px;font-size:18px;color:green;",
		divHoverStyle: "padding:4px;color:blue;background:#faebd7;font-size:20px;cursor:pointer;",
		beforeShow: function(text,callback){
				//先清掉所有数据
				//materialConfig.data = [];
				//callback(materialConfig);
				
				//ajax请求获取material
				$.ajax({
					type: "POST",
					url: "/mtdata/material/list",
					dataType: "json",
					data: { material: text },
					async: true, //同步请求
					success: function(result){
						//重新设置数据
						var rows = result.rows;
						for(var i in rows){
						    //第一个span是物料料号，第二个是trade_name
							materialConfig.data[i] = "<span>"+rows[i].material+"</span> - <span>"+rows[i].trade_name+"</span>";
						}
						//刷新显示的数据
						callback(materialConfig);
					}
				});
			}},
		clickHandler: function(el){
				   //第一个span是物料料号，第二个span是trade_name
				   var children = el.children;
				   $("#material").val(children[0].innerHTML);
				   $("#trade_name").val(children[1].innerHTML)
		    }
	}
	simpleSmartTip(testConfig);
	
 * */

	function simpleSmartTip(config){
		console.log("simpleSmartTip starting... "+config.el);
		
    	 if(config.el==null){
    		 console.log("没有绑定监听元素");
    		 return;
    	 }
    	 
    	 var el = $(config.el);
    	 if(el.attr('tipLoaded')==null){
    		 //设置是否初始化标志 （属性）
    		el.attr('tipLoaded', true);
    		//关闭浏览器的历史记录联想
    		el.attr('autocomplete', 'off');
    		
	    	//判断是否有设置容器，没有则创建一个
	    	if(config.showContainer==null){
	    		var container = document.createElement('div');
	    		el.parent().append(container);
	    		config.showContainer = container;
	    		
	    		config.containerStyle = ";position:absolute;"+config.containerStyle;
	    	}
	    	//添加容器的樣式
	    	if(config.containerStyle!=null){
	    		config.showContainer.style += config.containerStyle;
	    		
	    		//計算z-index值，比父元素大1且不能低于3
	    		var parentZ = config.showContainer.parentNode.style.zIndex;
	    		var z = parentZ==null || parentZ=='' || parentZ<3 ? 3:z+1;
	    		config.showContainer.style.zIndex = z;
	    		
	    		//父元素布局确认为 relative 或 absolute
	    		var position = config.showContainer.parentNode.style;
	    		if(position!='relative' && position!='absolute')
	    			config.showContainer.parentNode.style.position = 'relative';
	    		
	    	}
	    	
    		//失去鼠标聚焦，关闭提示  
    		/* 註：input元素blur事件會覆蓋掉下面div的單擊事件，父元素的blur事件也用不了
	    	el.parent().blur(function(){
	    		console.log('leave');
    			$(config.showContainer).hide();
    		}); */
    		
    	    //監聽屬性改變事件，文本改變時，value屬性就會發生改變
    	    //注：這裡要同時監聽 oninput 和 onpropertychange 兩個事件
    	    el.on('input propertychange', function(){
				var inputText = el.val();
				
    	    	//执行更新显示的信息
    	    	if(config.beforeShow!=null)
    	    		config.beforeShow(inputText, refreshTip);
    	   })
    	 }
     }
	
	//构建要展示的部分。
	function refreshTip(config){
    	$(config.showContainer).empty(); //清空舊元素
    	
		//最前面添加一个隐藏的输入的
    	var close = document.createElement('div');
    	close.innerHTML = " >>> cancel <<<";
    	if(config.divStyle != null){//添加样式
    		close.style = config.divStyle;
    		close.style.textAlign = 'center';
    	}
    	close.onclick = function (){ //添加关闭事件
    		$(config.showContainer).hide();
    	}
    	$(config.showContainer).append(close);
    	
    	//下面添加数据
    	for(var i=0; i<config.size && i<config.data.length; i++){
    		var div = document.createElement('div');
    		div.style = config.liStyle;
    		div.innerHTML = config.data[i];
	    	//添加单击事件
	    	div.onclick = function (){
	    		//自定义事件
	    		var hideTip = true;
    	    	if(config.clickHandler != null ){
    	    		hideTip = config.clickHandler(this);
    	    	}
    	    	//关闭提示
    	    	if(hideTip){
    	    		$(config.showContainer).hide();
    	    	}
	    	};
	    		//添加hover鼠標放上去的樣式
	    	if(config.divHoverStyle!=null){
	    		$(div).hover(function(){
	    			    this.style = config.divHoverStyle;
  	    		},function(){
  	    			this.style = config.divStyle;
  	    		});
	    	}
	    	//添加樣式
	    	if(config.divStyle != null){
	    		div.style = config.divStyle;
	    	}
	    	
			$(config.showContainer).append(div);//添加新元素
    	}
    	
		$(config.showContainer).show();
	}