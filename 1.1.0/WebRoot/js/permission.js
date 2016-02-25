/**
 * 
 */
$().ready(function(){
	permission.init.initEvent();
});

var permission = {
	//初始化相关
	init : {
		initData : function(){
			//用call来调用，this为当前点击的"设置权限"链接
			//本方法将对应的用户id及用户名设置到user数据区
			permission.data.user.username = $(this).parent().siblings("td:eq(1)").text();
			permission.data.user.uid = $(this).parent().siblings("input[type='hidden']:first").val();
		},
		initEvent : function(){
			//"设置权限"链接的点击事件
			$("a").each(function() {
				if($(this).text() == "设置权限"){
					$(this).unbind("click");
					$(this).bind("click", function(){
						//调用initData，设置当前点击链接对应的用户数据
						permission.init.initData.call(this);
						//将对应的用户数据显示出来
						permission.permFunc.showUserInfo();
						//显示所有隐藏的div
						permission.permFunc.showDiv();
						//加载权限树
						permission.permFunc.permissionTree.loadPermTree();
					});
				}
			});
			
			//权限树全选按钮的点击事件
			$("#allchecked").unbind("click");
			$("#allchecked").bind("click", function(){
				permission.permFunc.permissionTree.checkAll.call(this);
			});
			
			//保存权限按钮的点击事件
			$("#savePermTree").unbind("click");
			$("#savePermTree").bind("click", function(){
				permission.permFunc.permissionTree.savePermTree();
			});
		}
	},
	
	//方法区
	permFunc : {
		//将对应的用户数据显示出来
		showUserInfo : function(){
			$("#userImage").text(permission.data.user.username);
		},
		
		//显示所有隐藏的div
		showDiv : function(){
			$("#userTitle").show();
			$("#privilegeTitle").show();
			$("#privilegeContent").show();
		},
		
		permissionTree : {
			zTree : '',
			//zTree的设置
			setting : {
				isSimpleData: true,
		        treeNodeKey: "mid",
		        treeNodeParentKey: "pid",
		        showLine: true,
		        nameCol:"mname",
		        checkedCol: "isChecked",
		        root: {
		            isRoot: true,
		            nodes: []
		        },
		        checkable: true,
		        callback:{
		        	//点击复选框后，判断是否全选，若全选则全选按钮选中；
		        	//否则全选按钮为未选中状态
		        	change : function(treeId, treeNode){
		        		//通过getCheckedNodes(false)获取没被选中的复选框
						//如果不为空，即有未选中的，全选复选框不选中
						if(permission.permFunc.permissionTree.zTree.getCheckedNodes(false).length != 0){
							$("#allchecked").attr("checked",false);
						} else {
							//返回空，则没有未选中的，即已全选，则使全选复选框选中
							$("#allchecked").attr("checked", true);
						}
		        	}
		        }
			},
			
			//加载权限树
			loadPermTree : function(){
				$.post("menuAction_getMenusByUid.action", {uid : permission.data.user.uid}, function(data){
					//将data中的权限树数据加载到权限树的ul元素中
					permission.permFunc.permissionTree.zTree = $("#permissionTree").zTree(permission.permFunc.permissionTree.setting, data.menuList);
					//随后判断是否应该选中全选复选框
					//通过getCheckedNodes(false)获取没被选中的复选框
					//如果不为空，即有未选中的，全选复选框不选中
					if(permission.permFunc.permissionTree.zTree.getCheckedNodes(false).length != 0){
						$("#allchecked").attr("checked",false);
					} else {
						//返回空，则没有未选中的，即已全选，则使全选复选框选中
						$("#allchecked").attr("checked", true);
					}
				});
			},
			
			//全选按钮的动作
			checkAll : function(){
				if($(this).attr("checked")){
					permission.permFunc.permissionTree.zTree.checkAllNodes(true);
				} else {
					permission.permFunc.permissionTree.zTree.checkAllNodes(false);
				}
			},
			
			//保存权限树的内容(选择情况)
			savePermTree : function(){
				alert("保存权限树的内容");
			}
		}
	},
	
	//数据区
	data : {
		//保存当前用户数据
		user : {
			uid : '',
			username : ''
		}
	}
};