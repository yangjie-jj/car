<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html style="width: 100%;height:100%;">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 1.引入  layui相关文件  css 文件  -->
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"  />
<!-- 2. 引入 dtree相关文件 -   css 文件 -->
<link rel="stylesheet" href="${cxt}/resources/layui_ext/dtree/dtree.css" />
<link rel="stylesheet" href="${cxt}/resources/layui_ext/dtree/font/dtreefont.css">
</head>
<body style="width: 100%;height:100%;">
<div style="width: 20%;height:100%;float:left;border-right:1px solid #e2e2e2">
	<ul id="rightMenu" class="dtree" data-id="0"></ul>
</div>
<div style="width: 78%;height:100%;float:left;">
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="title">菜单名</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="title" placeholder="菜单名">
					</div>
				</div>
				<button id="searchBtn" class="layui-btn">搜索</button>
				</div>
			</div>
		
		</div>
	<div>
		<table id="dataTable" lay-filter="dataTableFilter"></table>
	</div>
</div>

	<!-- 更新模板 -->
	<script type="text/html" id="editForm">
	<div class="layui-form layui-form-pane" style="padding:5px" lay-filter="editFormFilter">
		<div class="layui-form-item">
			<div class="layui-block">
				<label class="layui-form-label">父菜单</label>
				<div class="layui-input-block">
					<input type="hidden"  id="parentId" name="parentId"  value="0" />
					<ul  data-id="0" id="parentMenu" name="parentMenu" ></ul>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">菜单名</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="title" placeholder="菜单名" lay-verify="required"  lay-reqText="请输入菜单名" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">连接地址</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="href" placeholder="连接地址"  />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">级别</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="lv" placeholder="级别" lay-verify="required"  lay-reqText="请输入菜单级别" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">菜单图标</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="icon" placeholder="菜单图标"  />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="sort" placeholder="排序"  />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">打开方式</label>
				<div class="layui-input-inline">
					<select name="target" >
						<option value="_self">当前窗口</option>
						<option value="_blank">新窗口</option>
					</select>
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">是否展开</label>
				<div class="layui-input-inline">
					<input type="radio"   value="1"  name="spread" title="展开" />
					<input type="radio"   value="0"  name="spread" title="不展开" />
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>
	</div>
	</script>
<script type="text/html" id="headBtns">
		<button lay-event="add" class="layui-btn layui-btn-sm">新增菜单</button>
		<button lay-event="delete" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
</script>
<script type="text/html" id="rowBtns">
		<button lay-event="update" class="layui-btn layui-btn-sm layui-btn-danger">修改菜单</button>
</script>
<!-- 1. 引入  layui相关文件   js 文件-->
<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
<script type="text/javascript">
	layui.extend({
		// 引入 dtree的  js
	    dtree: '${cxt}/resources/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
	  }).use(['dtree','layer','jquery','table','form'], function(){
		  //3. 初始化 dtree 对象
		  var dtree = layui.dtree;
		  var layer = layui.layer;
		  var $ = layui.jquery;
		  var table = layui.table;
		  var form = layui.form;
		  //5. 使用对象渲染树形结构
		 var tree =  dtree.render({
			  elem:"#rightMenu", // 树形容器的dom 
			  url: "${cxt}/sys/menu/allMenus.do",  // 数据接口
			  dataStyle: "layuiStyle",  //数据风格使用layui风格的数据格式 
			  dataFormat: "list", // 设置 数据格式为list 格式
			  response:{message:"msg",statusCode:200},  //设置响应数据的结果
			  //checkbar:true, //开启复选框   需要数据中含有checkArr 属性
			  //每个节点有2个图标  一级图标 指第一个图标   二级图标指第二个图标
			  ficon:["-1","-1"],   // 父节点和子节点的第一个图标
			  icon:["0","-1"],// 父节点和子节点的第二个图标
		  });
		  
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/sys/menu/list.do",
				page:true,
				toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'菜单ID',width:'80'},
					{field:'title',title:'菜单名',width:'100'},
					{field:'parentId',title:'父节点ID',width:'100'},
					{field:'href',title:'连接地址',width:'200'},
					{field:'lv',title:'级别',width:'80'},
					{field:'icon',title:'图标',width:'80',templet:function(d){
						return "<i class='layui-icon'>"+d.icon+"</i>";   
					}},
					{field:'flag',width:'80',title:'状态',templet:function(d){
							if(d.flag == 1){
								return "<font color='green'>有效</font>";
							}else if(d.flag == 2){
								return "<font color='red'>无效</font>";
							}
						},
					},
					{field:"sort",title:"排序",width:'80'},
					{field:"target",title:"打开方式",width:'120'},
					{field:"spread",title:"是否展开",width:'120',templet:function(d){
						if(d.spread == true){
							return "<font color='green'>展开</font>";
						}else if(d.spread == false){
							return "<font color='red'>不展开</font>";
						}
					}},
					{title:"操作",width:'150',toolbar:"#rowBtns",fixed:"right"},
				]],
				parseData:function(rs){
					if(rs.code == 200){
						return {
						      "code": rs.code, //解析接口状态
						      "msg": rs.msg, //解析提示文本
						      "count": rs.data.count, //解析数据长度
						      "data": rs.data.data //解析数据列表
						    };
					}
				},
				response: {
				        statusCode: 200  //规定成功的状态码，默认：0
				      } 
			});
			//  搜索功能
			$("#searchBtn").click(function(){
				var title = $("#title").val();
				t.reload({
					where:{
						'title':title,
					}
				});
				
			});
			// 行监听事件
			table.on("tool(dataTableFilter)",function(d){
				var event = d.event;
				var data = d.data;
				// 重置密码
				if(event == "update"){
					updateMenu(data)
				}
			});
			//修改菜单
			function updateMenu(menu){
				layer.open({
					type:1,
					content:$("#editForm").html(),
					area:['700px','400px'],
					success:function(layero,index){
						form.val("editFormFilter",menu);
						//重新渲染表单
						form.render();
						//渲染下拉树
						var selectTree = dtree.renderSelect({
							elem: "#parentMenu",
							url: "${cxt}/sys/menu/allMenus.do",  // 数据接口
							dataStyle: "layuiStyle",  //数据风格使用layui风格的数据格式 
							dataFormat: "list", // 设置 数据格式为list 格式
							response:{message:"msg",statusCode:200},  //设置响应数据的结果
							//每个节点有2个图标  一级图标 指第一个图标   二级图标指第二个图标
							ficon:["-1","-1"],   // 父节点和子节点的第一个图标
							icon:["0","-1"],// 父节点和子节点的第二个图标
							done: function(){
								//var params = dtree.dataInit("parentMenu", menu.parentId);
							    //dtree.click(selectTree, menu.parentId); // 会自动帮你触发一次对应Id的节点的点击事件
								dtree.selectVal("parentMenu", ""+menu.parentId);
							}
						});
						//监听下拉树菜单被点击
						dtree.on("node('parentMenu')" ,function(obj){
 							//选择了菜单后,将菜单的ID 作为当前菜单的父ID
 							$("#parentId").val(obj.param.nodeId);
						});
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							d.field.id = menu.id;
							$.post("${cxt}/sys/menu/update.do",d.field,function(rs){
								if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
								//刷新左侧菜单
								tree.reload();
								//关闭弹出层
								layer.close(index);
							})
							//阻止表单默认提交
							return false;
						});
					},
					btnAlign:'c',//按钮居中
					btn:['确认','取消'],
					yes:function(index,layero){
						//触发提交按钮点击
						$("#submitBtn").click();
					}
				});
				
			}
			// 头监听事件
			//=====新增功能===================================================
			table.on("toolbar(dataTableFilter)",function(d){
				var event = d.event;
				if(event == "add"){
					add();
				}else if(event == "delete"){
					deleteMenu();
				}
			});
			// 新增方法
			function add(){
				layer.open({
					type:1,
					content:$("#editForm").html(),
					area:['700px','400px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						//渲染下拉树
						dtree.renderSelect({
							elem: "#parentMenu",
							url: "${cxt}/sys/menu/allMenus.do",  // 数据接口
							dataStyle: "layuiStyle",  //数据风格使用layui风格的数据格式 
							dataFormat: "list", // 设置 数据格式为list 格式
							response:{message:"msg",statusCode:200},  //设置响应数据的结果
							//每个节点有2个图标  一级图标 指第一个图标   二级图标指第二个图标
							ficon:["-1","-1"],   // 父节点和子节点的第一个图标
							icon:["0","-1"],// 父节点和子节点的第二个图标
						});
						//监听下拉树菜单被点击
						dtree.on("node('parentMenu')" ,function(obj){
 							console.log(obj.param); // 点击当前节点传递的参数
 							//选择了菜单后,将菜单的ID 作为当前菜单的父ID
 							$("#parentId").val(obj.param.nodeId);
						});
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							$.post("${cxt}/sys/menu/add.do",d.field,function(rs){
								if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
								//刷新左侧菜单
								tree.reload();
								//关闭弹出层
								layer.close(index);
							})
							//阻止表单默认提交
							return false;
						});
					},
					btnAlign:'c',//按钮居中
					btn:['确认','取消'],
					yes:function(index,layero){
						//触发提交按钮点击
						$("#submitBtn").click();
					}
				});
			}
			// 删除菜单
			function deleteMenu(){
				// 获取选中的ID
				var checkStatus = table.checkStatus('dataTableId'); //idTest 即为基础参数 id 对应的值
				if(checkStatus.data.length == 0){
					layer.msg("请选择需要删除的菜单");
					return false;
				}
				var data = checkStatus.data;
				var ids = "";
				for(var i=0;i<data.length;i++){
					ids = ids+"id="+data[i].id+"&";
				}
				layer.confirm("确定要删除菜单吗?",function(index){
					$.post("${cxt}/sys/menu/delete.do?"+ids,function(d){
						if(d.code != 200){
							layer.msg(d.msg);
							return false;
						}
						$("#searchBtn").click();// 刷新表格
						//刷新左侧菜单
						tree.reload();
						layer.msg("菜单删除成功");
						layer.close(index);
					});
				});
			}
			
	  });

</script>
</body>
</html>