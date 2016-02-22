/**
 * 
 */
$().ready(function(){
	tree.loadTotalTree();
});

var tree = {
	setting:{
		isSimpleData: true,
        treeNodeKey: "mid",
        treeNodeParentKey: "pid",
        showLine: true,
        nameCol:"mname"
        /*root: {
            isRoot: true,
            nodes: []
        },*/
	},

	loadTotalTree:function(){
		$.post("menuAction_getAllMenus.action", null, function(data){
			$("#mytree").zTree(tree.setting, data.menuList);
		});
	}
};