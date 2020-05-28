<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出租列表</title>
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"/>
</head>
<body>
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="rentNo">出租单号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="rentNo" placeholder="出租单号">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="flag">出租状态</label>
					<div class="layui-input-inline">
						<select id="flag">
							<option value="">出租状态</option>
							<option value="2">已还车</option>
							<option value="1">未还车</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="carNum">车牌号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="carNum" placeholder="车牌号">
					</div>
				</div>
			</div>
		<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="idCard">客户身份证</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="idCard" placeholder="客户身份证">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="minCreateTime">订单时间</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="minCreateTime" placeholder="最小时间">
					</div>
					<div class="layui-form-mid">-</div>
					<div class="layui-input-inline">
						<input class="layui-input" id="maxCreateTime" placeholder="最大时间">
					</div>
				</div>
				<button id="searchBtn" class="layui-btn">搜索</button>
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
				<label class="layui-form-label">出租单号</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="rentNo"   readonly />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">检查时间</label>
				<div class="layui-input-inline">
					<input class="layui-input"  id="checkTime" name="checkTime" placeholder="检查时间"     readonly  lay-verify="required"  lay-reqText="请输入检查时间" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">参考金额</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="rentPrice" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">支付金额</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="payMoney" placeholder="实际支付金额"  lay-verify="required|number"  lay-reqText="请输入实际支付金额" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">问题</label>
				<div class="layui-input-inline">
					<input class="layui-input" name="problem"  value="无"      />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">描述</label>
				<div class="layui-input-block">
					<textarea name="desc" style="width:530px;height:80px"></textarea>
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>
	</div>
	</script>
	
	
	<script type="text/html" id="headBtns">
	</script>
	<script type="text/html" id="rowBtns">
		<button lay-event="returnBtn" class="layui-btn layui-btn-sm layui-btn-danger">还车</button>
	</script>
	<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','table','jquery','layer','laydate'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			var table = layui.table;
			var layer = layui.layer;
			var laydate = layui.laydate;
			
			laydate.render({
				elem:"#minCreateTime",
				type:"datetime"
			});
			laydate.render({
				elem:"#maxCreateTime",
				type:"datetime"
			});
			
			//初始化table
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/bussi/rent/list.do",
				page:true,
				toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'ID',width:'80'},
					{field:'rentNo',title:'租赁单号',width:'285'},
					{field:'price',title:'预计花费',width:'120'},
					{field:'beginTime',title:'起租时间',width:'180'},
					{field:'returnTime',title:'还车时间',width:'180'},
					{field:'flag',width:'80',title:'出租状态',templet:function(d){
							if(d.flag == 1){
								return "<font color='red'>未归还</font>";
							}else if(d.flag == 2){
								return "<font color='green'>已归还</font>";
							}
						},
					},
					{field:"idCard",title:"客户身份证",width:'180'},
					{field:"carNum",title:"车牌号",width:'100'},
					{field:"createTime",title:"创建时间",width:'180'},
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
				var rentNo = $("#rentNo").val();
				var flag = $("#flag").val();
				var idCard = $("#idCard").val();
				var carNum = $("#carNum").val();
				var minCreateTime = $("#minCreateTime").val();
				var maxCreateTime = $("#maxCreateTime").val();
				t.reload({
					where:{
						'rentNo':rentNo,
						'flag':flag,
						'idCard':idCard,
						'carNum':carNum,
						'minCreateTime':minCreateTime,
						'maxCreateTime':maxCreateTime
					}
				});
				
			});
			// 行监听事件
			table.on("tool(dataTableFilter)",function(d){
				var event = d.event;
				var data = d.data;
				if(event == "returnBtn"){
					returnCar(data);
				}
			});
			
			// 还车
			function returnCar(data){
				layer.open({
					type:1,
					content:$("#edit").html(),
					area:['700px','400px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						laydate.render({
							elem:"#checkTime",
							type:"datetime",
							value:new Date()
						});
						//初始form的数据
						form.val("editFormFilter",{
							"rentNo":data.rentNo,
							"rentPrice":data.price
						});
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							d.field.id = data.id;
							$.post("${cxt}/bussi/rent/returnCar.do",d.field,function(rs){
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