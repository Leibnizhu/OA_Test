/**
 * 
 */
$().ready(function(){
	//方法1：一次性加载整棵树
	//tree.loadTotalTree();
	//方法2：ready时只加载根节点，点击节点时再加载对应的子节点
	tree.loadRootNode();
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
        /*root: {
            isRoot: true,
            nodes: []
        },*/
        callback:{
        	expand:function(event, treeid, treeNode){
        		tree.pNode = treeNode;//当前点击的节点
        		tree.loadNodebyPnode();//点击时加载自节点们
        	}
        }
	},

	//加载整棵权限树
	loadTotalTree:function(){
		$.post("menuAction_getAllMenus.action", null, function(data){
			$("#mytree").zTree(tree.setting, data.menuList);
		});
	},
	
	//加载权限树的根节点
	loadRootNode:function(){
		$.post("menuAction_getMenusByPid.action", {pid : 0}, function(data){
			tree.zTree = $("#mytree").zTree(tree.setting, data.menuList);
		});
	},
	
	//根据父节点加载子节点
	loadNodebyPnode:function(){
		//alert("点击了父节点");
		$.post("menuAction_getMenusByPid.action", {pid : tree.pNode.mid}, function(data){
			tree.zTree.addNodes(tree.pNode, data.menuList, true);
		});
	}
};