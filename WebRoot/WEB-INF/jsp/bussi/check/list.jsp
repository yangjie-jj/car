<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>检查单列表</title>
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"/>
</head>
<body>
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="checkNo">检查单号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="checkNo" placeholder="检查单号">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="rentNo">出租单号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="rentNo" placeholder="出租单号">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="minCheckTime">检查时间</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="minCheckTime" placeholder="最小检查时间">
					</div>
					<div class="layui-form-mid">-</div>
					<div class="layui-input-inline">
						<input class="layui-input" id="maxCheckTime" placeholder="最大检查时间">
					</div>
				</div>
				<button id="searchBtn" class="layui-btn">搜索</button>
			</div>
		</div>
	</div>
	<div>
		<table id="dataTable" lay-filter="dataTableFilter"></table>
	</div>
	
	<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','table','jquery','layer','laydate'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			var table = layui.table;
			var layer = layui.layer;
			var laydate = layui.laydate;
			
			laydate.render({
				elem:"#minCheckTime",
				type:"datetime"
			});
			laydate.render({
				elem:"#maxCheckTime",
				type:"datetime"
			});
			
			//初始化table
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/bussi/check/list.do",
				page:true,
				//toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'ID',width:'80'},
					{field:'checkNo',title:'检查单号',width:'285'},
					{field:'rentNo',title:'出租单号',width:'285'},
					{field:'payMoney',title:'支付金额',width:'120'},
					{field:'checkTime',title:'检查时间',width:'180'},
					{field:'desc',title:'描述',width:'180'},
					{field:'problem',title:'问题',width:'180'},
					{field:"createTime",title:"创建时间",width:'180'}
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
				var checkNo = $("#checkNo").val();
				var minCheckTime = $("#minCheckTime").val();
				var maxCheckTime = $("#maxCheckTime").val();
				t.reload({
					where:{
						'rentNo':rentNo,
						'checkNo':checkNo,
						'minCheckTime':minCheckTime,
						'maxCheckTime':maxCheckTime
					}
				});
				
			});
			
		});
	</script>
</body>
</html>