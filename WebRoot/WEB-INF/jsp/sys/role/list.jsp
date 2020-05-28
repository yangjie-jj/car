<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色列表</title>
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"/>
<!-- 2. 引入 dtree相关文件 -   css 文件 -->
<link rel="stylesheet" href="${cxt}/resources/layui_ext/dtree/dtree.css" />
<link rel="stylesheet" href="${cxt}/resources/layui_ext/dtree/font/dtreefont.css">
</head>
<body>
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="realName">角色名</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="name" placeholder="角色名">
					</div>
				</div>
				<button id="searchBtn" class="layui-btn">搜索</button>
			</div>
		
		</div>
	</div>
	<div>
		<table id="dataTable" lay-filter="dataTableFilter"></table>
	</div>
	
	
	<!-- 更新模板 -->
	<script type="text/html" id="editForm">
	<div class="layui-form layui-form-pane" style="padding:5px" lay-filter="editFormFilter">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">角色名</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="name" placeholder="角色名" lay-verify="required"  lay-reqText="请输入角色名" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">角色介绍</label>
				<div class="layui-input-inline">
					<textarea name="description" style="width:200px;height:200px;"></textarea>
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>
	</div>
	</script>
	
	<script type="text/html" id="headBtns">
		<button lay-event="add" class="layui-btn layui-btn-sm">新增角色</button>
	</script>
	<script type="text/html" id="rowBtns">
		<button lay-event="update" class="layui-btn layui-btn-sm ">修改角色</button>
		<button lay-event="grant" class="layui-btn layui-btn-sm layui-btn-danger">分配权限</button>
	</script>
	<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
	<script type="text/javascript">
	layui.extend({
	 dtree: '${cxt}/resources/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
	  }).use(['dtree','form','table','jquery','layer'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			var table = layui.table;
			var layer = layui.layer;
			var dtree = layui.dtree;
			//初始化table
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/sys/role/list.do",
				page:true,
				toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'角色ID'},
					{field:'name',title:'角色名'},
					{field:'description',title:'描述'},
					{title:"操作",toolbar:"#rowBtns",fixed:"right"},
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
				var name = $("#name").val();
				t.reload({
					where:{
						'name':name
					}
				});
				
			});
			// 行监听事件
			table.on("tool(dataTableFilter)",function(d){
				var event = d.event;
				var data = d.data;
				// 重置密码
				if(event == "update"){
					updateRole(data)
				}else if(event == "grant"){
					grant(data);
				}
			});
			function updateRole(role){
				layer.open({
					type:1,
					content:$("#editForm").html(),
					area:['400px','400px'],
					success:function(layero,index){
						form.val("editFormFilter",role);
						//重新渲染表单
						form.render();
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							d.field.id = role.id;
							$.post("${cxt}/sys/role/update.do",d.field,function(rs){
								if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
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
				}
				
				
			});
			// 新增方法
			function add(){
				layer.open({
					type:1,
					content:$("#editForm").html(),
					area:['400px','400px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							$.post("${cxt}/sys/role/add.do",d.field,function(rs){
								if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
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
			//设置权限
			function grant(data){
				// 弹层
				layer.open({
					type:1,
					content:"<ul  data-id='0' id='menu' name='menu' ></ul>",
					area:['400px','400px'],
					success:function(layero,index){
						//获取所有的权限
						//渲染下拉树
						var menuTree = dtree.render({
							elem: "#menu",
							url: "${cxt}/sys/menu/allMenus.do",  // 数据接口
							dataStyle: "layuiStyle",  //数据风格使用layui风格的数据格式 
							dataFormat: "list", // 设置 数据格式为list 格式
							response:{message:"msg",statusCode:200},  //设置响应数据的结果
							//每个节点有2个图标  一级图标 指第一个图标   二级图标指第二个图标
							ficon:["-1","-1"],   // 父节点和子节点的第一个图标
							icon:["0","-1"],// 父节点和子节点的第二个图标
							checkbar:true,//开启复选框
							done: function(){
								//var params = dtree.dataInit("parentMenu", menu.parentId);
							    //dtree.click(selectTree, menu.parentId); // 会自动帮你触发一次对应Id的节点的点击事件
								//dtree.selectVal("parentMenu", ""+menu.parentId);
							    // 获取当前角色的所有权限 ID
							    //进行权限初始化  选中
							    $.get("${cxt}/sys/menu/getRoleMenu.do",{"roleId":data.id},function(rs){
							    	if(rs.code != 200){
							    		layer.msg(rs.msg);
							    		return false;
							    	}
							    	var ids =  rs.data;
							      dtree.chooseDataInit("menu",ids);
							    });
							}
						});
					},
					btnAlign:'c',//按钮居中
					btn:['确认','取消'],
					yes:function(index,layero){
						// 获取选中的复选框
						var params = dtree.getCheckbarNodesParam("menu");
						var menuIds = "";
						//循环获取所有的菜单ID
						$.each(params,function(index,value){
							menuIds = menuIds +"menuId="+value.nodeId+"&";
						});
						$.post("${cxt}/sys/menu/setRoleMenu.do?"+menuIds,{"roleId":data.id},function(rs){
							if(rs.code != 200){
								layer.msg(rs.msg);
								return false;
							}
							layer.msg("权限分配成功!");
							layer.close(index);
						})
						
						
					}
				});
				
				
				
				
				
				
			}
			
			
			
			
			
		});
	
	
	</script>
</body>
</html>