/**
 * 
 */
$().ready(function(){
	//加载知识管理树
	kynamic.kynamicTree.loadKynamicTree();
	//给菜单项增加事件
	$("#rightMenu").hover(
		function(){},
		function(){
			//鼠标移出时，隐藏菜单
			$("#rightMenu").hide();
		}
	);
});

var kynamic = {
	//知识树
	kynamicTree : {
		zTree : '',
		pNode : '',
		setting : {
			isSimpleData: true,
	        treeNodeKey: "kid",
	        treeNodeParentKey: "pid",
	        showLine: true,
	        nameCol:"kname",
	        root: {
	            isRoot: true,
	            nodes: []
	        },
	      //通过setting中的keep.parent，在删除所有子节点之后父节点保持isParent属性
	        keepParent : true,
	        callback:{
	        	//知识树的右击事件，
	        	rightClick : function(event, treeid, treeNode){
	        		//先将点击的节点放入pNode，以便于addNode在增加节点时传递给服务器
	        		kynamic.kynamicTree.pNode = treeNode;
	        		//判断当前点击的节点是文件夹节点还是文件节点
	        		if(treeNode.isParent){
	        			//调用处理右击菜单的方法
	        			kynamic.kynamicTree.showRightMenu({
	        				x : event.clientX,
	        				y : event.clientY,
	        				addFile: true,
                            addFolder: true,
                            deleteFile: true,
                            updateFile: true
	        			});
	        		} else {
	        			//文件节点
	        			kynamic.kynamicTree.showRightMenu({
	        				x : event.clientX,
	        				y : event.clientY,
	        				addFile: false,
	        				addFolder: false,
	        				deleteFile: true,
	        				updateFile: true
	        			});
	        		}
	        	},
	        	//知识树的左击事件:显示version版本信息
	        	click : function(event, treeid, treeNode){
	        		//先将点击的节点放入pNode
	        		kynamic.kynamicTree.pNode = treeNode;
	        		//发出ajax请求查询当前节点对应的version
	        		$.post("kynamicAction_getVersionsByKid.action", {kid : kynamic.kynamicTree.pNode.kid}, function(data){
	        			if(0 == data.versionList.length){
	        				//没有对应的版本信息，显示新建
	        			} else {
	        				//显示版本信息及checkin checkout
	        				kynamic.version.showVersionBox({
	        					addVersion : false,
	        					checkin : false,
	        					checkout : false,
	        					versionList : true
	        				});
	        				kynamic.version.showVersionList(data.versionList);
	        			}
	        		});
	        	}
	        }
		},
		//加载树
		loadKynamicTree : function(){
			$.post("kynamicAction_showTree.action", null, function(data){
				kynamic.kynamicTree.zTree = $("#kynamicTree").zTree(kynamic.kynamicTree.setting, data.menuList);
				kynamic.kynamicTree.menuClickEvent();
			});
		},
		
		//加载菜单项的点击事件
		menuClickEvent : function(){
			$("#addFile").unbind("click");
	        $("#addFile").bind("click", function(){
	            kynamic.kynamicTree.addFile();
	        });
	        
	        $("#addFolder").unbind("click");
	        $("#addFolder").bind("click", function(){
	            kynamic.kynamicTree.addFolder();
	        });
	        
	        $("#deleteFile").unbind("click");
	        $("#deleteFile").bind("click", function(){
	            kynamic.kynamicTree.deleteFile();
	        });
	        
	        $("#updateFile").unbind("click");
	        $("#updateFile").bind("click", function(){
	            kynamic.kynamicTree.updateFile();
	        });
		},
		
		//根据点击的位置显示菜单，斌根据节点的属性（menuJson中的属性，判定需要显示哪些菜单项）
		showRightMenu : function(menuJson){
			//先显示右键菜单的div
			$("#rightMenu").show();
			$("#rightMenu").css({
				//更改菜单的位置，x和y不要搞错了
				"top" : menuJson.y + "px",
				"left" : menuJson.x + "px",
				"display": "block"
			});
			//根据menuJson的内容，决定每个菜单项是否显示
			if(menuJson.addFile){
				$("#addFile").show();
			} else {
				$("#addFile").hide();
			}
			
			if(menuJson.addFolder){
				$("#addFolder").show();
			} else {
				$("#addFolder").hide();
			}
			
			if(menuJson.deleteFile){
				$("#deleteFile").show();
			} else {
				$("#deleteFile").hide();
			}
			
			if(menuJson.updateFile){
				$("#updateFile").show();
			} else {
				$("#updateFile").hide();
			}
		},
		
		//增加文件
		addFile : function(){
			//alert("addFile");
			kynamic.kynamicTree.addNode({
				inputMsg : '请输入文件名',
				errMsg : '文件名不能为空',
				isParent : false
			});
		},
		
		//增加文件夹
		addFolder : function(){
			//alert("addFolder");
			kynamic.kynamicTree.addNode({
				inputMsg : '请输入文件夹名',
				errMsg : '文件夹名不能为空',
				isParent : true
			});
		},
		
		//增加一个节点，文件或文件夹
		addNode : function(addJson){
			//通过系统提示框获得输入的节点名
			var nodeName = window.prompt(addJson.inputMsg);
			if(null != nodeName && "" != nodeName){
				//发出ajax请求判断是否重名
				$.post("kynamicAction_isNameExists.action", {kname : nodeName}, function(data){
					if(data.returnMsg == "0"){
						//存在重名
						alert("存在重名，请重新输入");
					} else {
						//没有重名，可以新增节点，提交ajax请求
						$.post("kynamicAction_addKynamic.action",
							{
								kname : nodeName,
								isParent : addJson.isParent,
								pid : kynamic.kynamicTree.pNode.kid
							},
							function(data2){
								//回调，往知识管理树里面添加节点
								kynamic.kynamicTree.zTree.addNodes(kynamic.kynamicTree.pNode,
																						{
																							kid : data2.kid,
																							pid : kynamic.kynamicTree.pNode.kid,
																							kname : nodeName,
																							isParent : addJson.isParent
																						},
																						true);
								alert(data2.returnMsg);
							}
						);
					}
				});
			} else {
				//输入节点名为空，提示错误
				alert(addJson.errMsg);
			}
		},
		
		//删除文件
		deleteFile : function(){
			//alert("deleteFile");
			//判断当前节点是否文件夹节点
			if(kynamic.kynamicTree.pNode.isParent){
				if(kynamic.kynamicTree.zTree.getNodeByParam("pid", kynamic.kynamicTree.pNode.kid)){
					//查询pid为当前点击节点的kid的节点，即当前节点的子节点，若不为空，则不能删除
					alert("当前文件夹不为空，不能直接删除！");
				} else {
					//没有子节点，可以删除，发出ajax请求删除节点
					$.post("kynamicAction_deleteKynamic.action", {kid : kynamic.kynamicTree.pNode.kid}, function(data){
						//通过setting中的keep.parent，在删除所有子节点之后父节点保持isParent属性
						kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
						alert(data.returnMsg);
					});
				}
			} else {
				//文件节点则提示是否删除
				if(window.confirm("确认删除？")){
					//发出ajax请求删除节点
					$.post("kynamicAction_deleteKynamic.action", {kid : kynamic.kynamicTree.pNode.kid}, function(data){
						//通过setting中的keep.parent，在删除所有子节点之后父节点保持isParent属性
						kynamic.kynamicTree.zTree.removeNode(kynamic.kynamicTree.pNode);
						alert(data.returnMsg);
					});
				}
			}
		},
		
		//修改文件节点
		updateFile: function(){
			//alert("updateFile");
			//通过系统提示框获得输入的节点名
			var newName = window.prompt("请输入新名字：");
			if(null != newName && "" != newName){
				//发出ajax请求判断是否重名
				$.post("kynamicAction_isNameExists.action", {kname : newName}, function(data){
					if(data.returnMsg == "0"){
						//存在重名
						alert("存在重名，请重新输入");
					} else {
						//没有重名，可以新增节点，提交ajax请求
						$.post("kynamicAction_updateKynamic.action",
							{
								kname : newName,
								kid : kynamic.kynamicTree.pNode.kid
							},
							function(data2){
								//回调，修改当前节点名字
								kynamic.kynamicTree.pNode.kname = newName;
								kynamic.kynamicTree.zTree.refresh();
							}
						);
					}
				});
			} else {
				//输入节点名为空，提示错误
				alert("输入名字不能为空");
			}
		}
	},
	//版本
	version : {
		//根据showJson传入的数据，决定显示哪些内容
		showVersionBox : function(showJson){
			if(showJson.addVersion){
				$("#addVersion").show();
			} else {
				$("#addVersion").hide();
			}
			if(showJson.checkin){
				$("#checkin").show();
			} else {
				$("#checkin").hide();
			}
			if(showJson.checkout){
				$("#checkout").show();
			} else {
				$("#checkout").hide();
			}
			if(showJson.versionList){
				$("#versionList").show();
			} else {
				$("#versionList").hide();
			}
		},
		//根据ajax返回的version列表，生成table并显示
		/*<tr>
	    <td height="26" align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;"><a>1</a></td>
	    <td align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;">2010-5-24 09:56:33</td>
	    <td align="center" valign="middle" bgcolor="#FFFFFF" style="border-bottom:1px solid #f3f8fd;"><a>删除</a></td>
	  </tr>*/
		showVersionList : function(versionList){
			//先清空原有内容，以防重复显示
			$("#showVersion").empty();
			for(var i = 0; i < versionList.length; i++){
				(function(){
					var version = versionList[i].version;
					var updatetime = versionList[i].updatetime;
					var content = versionList[i].content;
					var title = versionList[i].title;
					//版本号的超链接
					var $versionA = $("<a/>");
					$versionA.text(version);
					$versionA.css("cursor", "pointer");
					//绑定点击事件
					$versionA.unbind("click");
					$versionA.bind("click", function(){
						alert("Title : " + title + ". Content : " + content);
					});
					
					//版本号的单元格
					var $versionTd = $("<td/>");
					$versionTd.attr("height", "26").attr("align", "center").attr("valign", "middle").attr("bgcolor", "#FFFFFF").attr("style", "border-bottom:1px solid #f3f8fd;");
					$versionTd.append($versionA);
					//更新时间的单元格
					var $updateTd = $("<td/>");
					$updateTd.attr("align", "center").attr("valign", "middle").attr("bgcolor", "#FFFFFF").attr("style", "border-bottom:1px solid #f3f8fd;");
					$updateTd.text(updatetime);
					//删除的超链接
					var $delA = $("<a/>");
					$delA.text("删除");
					//删除的单元格
					var $delTd = $("<td/>");
					$delTd.attr("align", "center").attr("valign", "middle").attr("bgcolor", "#FFFFFF").attr("style", "border-bottom:1px solid #f3f8fd;");
					$delTd.append($delA);
					
					//行
					var $versionTr = $("<tr/>");
					$versionTr.append($versionTd);
					$versionTr.append($updateTd);
					$versionTr.append($delTd);
					
					//加入到表格
					$("#showVersion").append($versionTr);
				})();
			}
		}
	}
};