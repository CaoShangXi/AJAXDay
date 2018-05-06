function getXhr(){
	//获取AJAX对象
	var xhr=null;
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		//针对ie浏览器下获取AJAX对象
		//确保ie6浏览器正常运行，更古老浏览器无视
	xhr=new ActiveXObject("Microsoft.XMLHttp");
	}
	return xhr;
}
function $(id){
	return document.getElementById(id);
}
function $F(id){
	return $(id).value();
}