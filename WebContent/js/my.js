function getXhr(){
	//��ȡAJAX����
	var xhr=null;
	if(window.XMLHttpRequest){
		xhr=new XMLHttpRequest();
	}else{
		//���ie������»�ȡAJAX����
		//ȷ��ie6������������У����������������
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