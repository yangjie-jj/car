<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车辆列表</title>
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"/>
</head>
<body>
	<div style="padding:5px">
		<div class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="carNum">车牌号</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="carNum" placeholder="车牌号">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="color">颜色</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="color" placeholder="颜色">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="minPrice">车辆价格</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="minPrice" placeholder="最低价格">
					</div>
					<div class="layui-form-mid">-</div>
					<div class="layui-input-inline">
						<input class="layui-input" id="maxPrice" placeholder="最高价格">
					</div>
				</div>
			</div>
		<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label" for="minRentPrice">出租价格</label>
					<div class="layui-input-inline">
						<input class="layui-input" id="minRentPrice" placeholder="最低价格">
					</div>
					<div class="layui-form-mid">-</div>
					<div class="layui-input-inline">
						<input class="layui-input" id="maxRentPrice" placeholder="最高价格">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label" for="phone">状态</label>
					<div class="layui-input-inline">
						<select id="isRent">
							<option value="">车辆状态</option>
							<option value="1">未出租</option>
							<option value="2">已出租</option>
						</select>
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
		<div style="width:250px;float:right;display:inline-block">
			<img src="${cxt}/resources/images/bg2.jpg" id="carImg"  style="width:200px;height:160px;"  />
		</div>
		<div class="layui-form-item" style="width:250px;display:inline-block">
			<div class="layui-inline">
				<label class="layui-form-label">车牌号</label>
				<div class="layui-input-block">
					<input class="layui-input" id="addCarNum" name="carNum" placeholder="车牌号" lay-verify="required"  lay-reqText="车牌号" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">车型</label>
				<div class="layui-input-block">
					<input class="layui-input" id="addType"  name="type" placeholder="SUV/轿车/跑车" lay-verify="required"  lay-reqText="请输入车型" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">颜色</label>
				<div class="layui-input-block">
					<input class="layui-input" id="addColor" name="color" placeholder="颜色" lay-verify="required"  lay-reqText="请输入车辆颜色" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">价格</label>
				<div class="layui-input-block">
					<input class="layui-input" id="addPrice" name="price" placeholder="价格" lay-verify="required|number"  lay-reqText="请输入车辆价格" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">出租价格</label>
				<div class="layui-input-inline" style="width:150px">
					<input class="layui-input" id="addRentPrice" name="rentPrice" placeholder="出租价格" lay-verify="required"  lay-reqText="请输入出租价格" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">押金</label>
				<div class="layui-input-inline"  style="width:150px">
					<input class="layui-input" id="addDeposit" name="deposit" placeholder="押金" lay-verify="required"  lay-reqText="请输入押金" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">车辆描述</label>
				<div class="layui-input-inline">
					<textarea name="desc" id="addDesc" style="width:435px;height:110px" ></textarea>
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>

		<input type="hidden"  id="uploadBtn" />
	</div>
	</script>
	<!-- 出租 -->
	<script type="text/html" id="rent">
		<div class="layui-form layui-form-pane" style="padding:5px" lay-filter="rentFormFilter">
		<p style="color:#c2c2c2;margin:5px">计费规则:1天起租,不足24小时算1天</p>
		<div class="layui-form-item" >
			<div class="layui-inline">
				<label class="layui-form-label">车牌号</label>
				<div class="layui-input-block">
					<input class="layui-input" id="addCarNum" name="carNum" readonly placeholder="车牌号" lay-verify="required"  lay-reqText="车牌号" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">身份证</label>
				<div class="layui-input-block">
					<input class="layui-input"   name="idCard" placeholder="客户身份证" lay-verify="required|identity"  lay-reqText="请输入客户身份证" />
				</div>
			</div>
			
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-block">
					<input class="layui-input" id="beginTime"  name="beginTime" placeholder="起租时间" lay-verify="required"  lay-reqText="请输入起租时间"  readonly />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">还车时间</label>
				<div class="layui-input-block">
					<input class="layui-input"  id="returnTime" name="returnTime" placeholder="还车时间" lay-verify="required"  lay-reqText="请输入还车时间" />
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">每日单价</label>
				<div class="layui-input-inline">
					<input class="layui-input"  id="rentPrice"  name="rentPrice"  readonly />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">预计费用</label>
				<div class="layui-input-inline">
					<input class="layui-input"  id="money" value="0" readonly />
				</div>
			</div>
		</div>
		<input type="hidden"  id="submitBtn" lay-filter="submitBtnFilter" lay-submit/>
	</div>
	</script>
	<script type="text/html" id="headBtns">
		<button lay-event="add" class="layui-btn layui-btn-sm">新增车辆</button>
	</script>
	<script type="text/html" id="rowBtns">
		<button lay-event="edit" class="layui-btn layui-btn-sm layui-btn-danger">修改</button>
		<button lay-event="rent" class="layui-btn layui-btn-sm">出租</button>
	</script>
	<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use(['form','table','jquery','layer','upload','laydate'],function(){
			var form = layui.form;
			var $ = layui.jquery;
			var table = layui.table;
			var layer = layui.layer;
			var upload = layui.upload;
			var laydate = layui.laydate;
			// 租车时间
			var beginTimeObj = new Date();
			// 还车时间
			var returnTimeObj = null;
			
			//初始化table
			var t = table.render({
				id:'dataTableId',
				elem:"#dataTable",
				url:"${cxt}/bussi/car/list.do",
				page:true,
				toolbar:"#headBtns",
				height:"520px",
				cols:[[
					{type:'checkbox'},
					{field:'id',title:'ID',width:'80'},
					{field:'carNum',title:'车牌号',width:'100'},
					{field:'type',title:'车型',width:'100'},
					{field:'color',title:'颜色',width:'100'},
					{field:'price',title:'价格',width:'120'},
					{field:'rentPrice',title:'出租价格',width:'120'},
					{field:'deposit',title:'押金',width:'100'},
					{field:'desc',title:'描述',width:'300'},
					{field:'isRent',width:'80',title:'状态',templet:function(d){
							if(d.isRent == 1){
								return "<font color='green'>未出租</font>";
							}else if(d.isRent == 2){
								return "<font color='red'>已出租</font>";
							}
						},
					},
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
				var carNum = $("#carNum").val();
				var color = $("#color").val();
				var minPrice = $("#minPrice").val();
				var maxPrice = $("#maxPrice").val();
				var minRentPrice = $("#minRentPrice").val();
				var maxRentPrice = $("#maxRentPrice").val();
				var isRent = $("#isRent").val();
				t.reload({
					where:{
						'carNum':carNum,
						'color':color,
						'minPrice':minPrice,
						'maxPrice':maxPrice,
						'minRentPrice':minRentPrice,
						'maxRentPrice':maxRentPrice,
						'isRent':isRent
					}
				});
				
			});
			// 行监听事件
			table.on("tool(dataTableFilter)",function(d){
				var event = d.event;
				var data = d.data;
				if(event == "edit"){
					console.log(data);
					edit(data);
				}else if(event == 'rent'){
					rent(data);
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
			// 新增车辆方法
			function add(){
				layer.open({
					type:1,
					content:$("#edit").html(),
					area:['600px','500px'],
					success:function(layero,index){
						//重新渲染表单
						form.render();
						//初始化图片上传的组件
						//选完文件后不自动上传
						upload.render({
						    elem: '#carImg'
						    ,url: '${cxt}/bussi/car/add.do'
						    ,auto: false
						    //,multiple: true
						    ,bindAction: '#uploadBtn'
						    ,field:"carImg"
						    ,data: {
						    		  'carNum': function(){
						    		    return $('#addCarNum').val();
						    		  },
						    		  'type':function(){
						    			  return $('#addType').val();
						    		  },
						    		  'color':function(){
						    			  return $('#addColor').val();
						    		  },
						    		  'price':function(){
						    			  return $('#addPrice').val();
						    		  },
						    		  'rentPrice':function(){
						    			  return $('#addRentPrice').val();
						    		  },
						    		  'deposit':function(){
						    			  return $('#addDeposit').val();
						    		  },
						    		  'desc':function(){
						    			  return $('#addDesc').val();
						    		  },
						    		}
						    ,done: function(rs){
						    	if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
								//关闭弹出层
								layer.close(index);
						    }
						    ,choose: function(obj){
						        //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
						        obj.preview(function(index, file, result){
						          $("#carImg").attr("src",result);
						        });
						      }
						  });
						
						
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							$("#uploadBtn").click();
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
			// 修改车辆
			function edit(d){
				layer.open({
					type:1,
					content:$("#edit").html(),
					area:['600px','500px'],
					success:function(layero,index){
						debugger;
						//初始化表单数据
						form.val("editFormFilter",d);
						// 设置图片
						$("#carImg").attr("src",'${cxt}/'+d.img);
						//重新渲染表单
						form.render();
						
						//初始化图片上传的组件
						//选完文件后不自动上传
						upload.render({
						    elem: '#carImg'
						    ,url: '${cxt}/bussi/car/update.do'
						    ,auto: false
						    //,multiple: true
						    ,bindAction: '#uploadBtn'
						    ,field:"carImg"
						    ,data: {
						    	 	'id': function(){
						    		    return d.id;
						    		  },
						    		  'carNum': function(){
						    		    return $('#addCarNum').val();
						    		  },
						    		  'type':function(){
						    			  return $('#addType').val();
						    		  },
						    		  'color':function(){
						    			  return $('#addColor').val();
						    		  },
						    		  'price':function(){
						    			  return $('#addPrice').val();
						    		  },
						    		  'rentPrice':function(){
						    			  return $('#addRentPrice').val();
						    		  },
						    		  'deposit':function(){
						    			  return $('#addDeposit').val();
						    		  },
						    		  'desc':function(){
						    			  return $('#addDesc').val();
						    		  },
						    		}
						    ,done: function(rs){
						    	if(rs.code != 200){
									layer.msg(rs.msg);
									return false;
								}
								$("#searchBtn").click();// 刷新表格
								//关闭弹出层
								layer.close(index);
						    }
						    ,choose: function(obj){
						        //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
						        obj.preview(function(index, file, result){
						          $("#carImg").attr("src",result);
						        });
						      }
						  });
						
						
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(d){
							$("#uploadBtn").click();
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
			
			// 车辆出租
			function rent(d){
				layer.open({
					type:1,
					content:$("#rent").html(),
					area:['700px','400px'],
					success:function(layero,index){
						//初始化表单数据
						form.val("rentFormFilter",{
							'carNum':d.carNum,
							'rentPrice':d.rentPrice
						});
						//重新渲染表单
						form.render();
						//渲染时间组件
						laydate.render({
							elem:"#beginTime",
							type:'datetime',
							value:new Date(),
							done: function(value, date, endDate){
								beginTimeObj = new Date(date.year,date.month-1,date.date,date.hours,date.minutes);
								if(returnTimeObj != null && returnTimeObj != null ){
									complateMoney(beginTimeObj.getTime(),returnTimeObj.getTime());
									return false;
								}
								layer.msg("请选择还车时间");
							}
						});
						//渲染时间组件
						laydate.render({
							elem:"#returnTime",
							type:'datetime',
							done: function(value, date, endDate){
								returnTimeObj = new Date(date.year,date.month-1,date.date,date.hours,date.minutes);
								if(returnTimeObj != null && beginTimeObj != null){
									complateMoney(beginTimeObj.getTime(),returnTimeObj.getTime());
									return false;
								}
								layer.msg("请选择起租时间");
							}
						});
						
						//为表单新增提交监听事件
						form.on("submit(submitBtnFilter)",function(formDate){
							formDate.field.carId = d.id;
							$.post("${cxt}/bussi/car/rent.do",formDate.field,function(rs){
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
			// 计算起租和还车时间及其大致金额
			function complateMoney(beginTime,returnTime){
				var rentPrice = $("#rentPrice").val();
				if((returnTime - beginTime) <= 0){
					layer.msg("还车时间有误")
					return false;
				}
				var times = returnTime - beginTime;
				//1天的毫秒数
				var hs = 24*60*60*1000;
				//计算最近天数
				var days = Math.ceil(times/hs);
				$("#money").val(days*rentPrice);
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