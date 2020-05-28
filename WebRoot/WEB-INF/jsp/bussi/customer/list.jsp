<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"/>
</head>
<body>
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="idCard">身份证号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="idCard" placeholder="身份证号">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="custName">客户名称</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="custName" placeholder="客户名称">
					</div>
				</div>
			</div>
		<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="address">地址</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="address" placeholder="地址">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="phone">手机号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="phone" placeholder="手机号">
					</div>
				</div>
				<button id="searchBtn" class="layui-btn">搜索</button>
				<button id="exportBtn" class="layui-btn">导出</button>
			</div>
		</div>
	</div>
	<div>
		<table id="dataTable" lay-filter="dataTableFilter"></table>
	</div>
	
	<!-- 编辑 -->
	<script type="text/html" id="edit">
		<div class="layui-form layui-form-pane" style="padding:5px" lay-filter="editFormFilter">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">客户名称</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="custName" placeholder="客户名称" lay-verify="required"  lay-reqText="客户名称" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">身份证号</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="idCard" placeholder="身份证号" lay-verify="required|identity"  lay-reqText="请输入身份证号" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-inline">
					<input type="radio" name="sex" value="1" checked title="男" />
					<input type="radio" name="sex" value="2"  title="女" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="address" placeholder="地址" lay-verify="required"  lay-reqText="请输入地址" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="phone" placeholder="手机号" lay-verify="required|phone"  lay-reqText="请输入手机号" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">职位</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="position" placeholder="职位" lay-verify="required"  lay-reqText="请输入职位" />
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>
	</div>
	</script>
	
	
	<script type="text/html" id="headBtns">
		<button lay-event="add" class="layui-btn layui-btn-sm">新增客户</button>
	</script>
	<script type="text/html" id="rowBtns">
		<button lay-event="edit" class="layui-btn layui-btn-sm layui-btn-danger">修改</button>
	</script>
	<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','table','jquery','layer'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			var table = layui.table;
			var layer = layui.layer;
			//初始化table
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/bussi/customer/list.do",
				page:true,
				toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'用户ID',width:'80'},
					{field:'custName',title:'客户名称',width:'100'},
					{field:'idCard',title:'身份证',width:'200'},
					{field:'sex',width:'80',title:'性别',templet:function(d){
							if(d.sex == 1){
								return "男";
							}else if(d.sex == 2){
								return "女";
							}
						},
					},
					{field:"address",title:"地址",width:'200'},
					{field:"phone",title:"手机号",width:'150'},
					{field:"position",title:"职位",width:'150'},
					{field:"createTime",title:"创建时间",width:'150'},
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
				var idCard = $("#idCard").val();
				var phone = $("#phone").val();
				var custName = $("#custName").val();
				var address = $("#address").val();
				t.reload({
					where:{
						'idCard':idCard,
						'phone':phone,
						'custName':custName,
						'address':address
					}
				});
				
			});
			// 行监听事件
			table.on("tool(dataTableFilter)",function(d){
				var event = d.event;
				var data = d.data;
				if(event == "edit"){
					edit(data);
				}
			});
			
			// 头监听事件
			//=====用户新增功能===================================================
			table.on("toolbar(dataTableFilter)",function(d){
				var event = d.event;
				if(event == "add"){
					add();
				}
				
				
			});
			// 新增客户方法
			function add(){
				layer.open({
					type:1,
					content:$("#edit").html(),
					area:['700px','400px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							$.post("${cxt}/bussi/customer/add.do",d.field,function(rs){
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
			// 修改客户
			function edit(data){
				layer.open({
					type:1,
					content:$("#edit").html(),
					area:['700px','400px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						//初始form的数据
						form.val("editFormFilter",data);
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							d.field.id = data.id;
							$.post("${cxt}/bussi/customer/update.do",d.field,function(rs){
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
			
			
			
			// 导出的
			$("#exportBtn").click(function(){
				var idCard = $("#idCard").val();
				var phone = $("#phone").val();
				var custName = $("#custName").val();
				var address = $("#address").val();
				location.href="${cxt}/bussi/customer/export.do?idCard="+idCard+"&phone="+phone+"&custName="+custName+"&address="+address;
			});
		});
	
	
	</script>
</body>
</html>