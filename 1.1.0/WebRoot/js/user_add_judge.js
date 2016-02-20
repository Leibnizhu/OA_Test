/**
 * 
 */
$().ready(function(){
	$("input[type='image']").unbind("click");
	$("input[type='image']").bind("click", function(){
		//空格时父子选择器，在name属性为did的select父节点下面，option标签被选中的元素子节点
		//的值为空
		if($("select[name='did'] option:selected").attr("value")==""){
			alert("请选择用户所属的部门");
			return false;
		} else if(!$("select[name='jids'] option:selected").attr("value")){
			alert("请选择用户对应的职位");
			return false;
		} else {
			return true;
		}
	});
});