/**
 * 
 */
$().ready(function(){
	//一次性加载整棵树
	tree.loadTotalTree();
});

var tree = {
	zTree: '',
	pNode:'',
	setting:{
		isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        nameCol:"mname",
        checkedCol: "isChecked",
        target : "right"
	},

	//加载整棵权限树
	loadTotalTree:function(){
		$.post("menuAction_getMenusByCurUser.action", null, function(data){
			tree.zTree = $("#menuTree").zTree(tree.setting, data.menuList);
			//tree.zTree.expandAll(true);
		});
	},
};