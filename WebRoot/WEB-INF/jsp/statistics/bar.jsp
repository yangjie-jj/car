<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>年业务员销售额</title>
<!-- 1.引入  layui相关文件  css 文件  -->
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"  />
</head>
<body>
<div class="layui-form layui-form-pane">
	<div class="layui-item">
		<label class="layui-form-label">
			年份
		</label>
		<div class="layui-input-inline">
			<input id="year" class="layui-input"  />
		</div>
		<button class="layui-btn" id="searchBtn">查询</button>
	</div>
</div>

<div id="lineContent" style="width: 800px;height:500px"></div>
<!-- 2. 引入echarts js -->
<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
<script type="text/javascript" src="${cxt}/resources/echarts.js"></script>
<script type="text/javascript">
	layui.use(['jquery','layer','laydate'],function(){
		var $ = layui.jquery;
		var layer = layui.layer;
		var laydate = layui.laydate;
		// 初始化时间
		var t = laydate.render({
			elem:"#year",
			type:"year",
			value:new Date()
		});
		console.log(t);
		// 初始化echart 对象
		var chart = echarts.init(document.getElementById('lineContent'));
		// 图表的参数
		var option = {
		    color: ['#3398DB'],
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : 
		        {
		            type : 'category',
		            data :null,// 员工
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ,
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
	    series : 
	        {
	            name:'年度销售额',
	            type:'bar',
	            barWidth: '60%',
	            data:[10, 52, 200, 334]
	        }
	};
		$("#searchBtn").click(function(){
			var value = t.config.value;
			var year = $("#year").val();
			if(year == null || year == ''){
				year = new Date().getFullYear();
			}
			$.post("${cxt}/sys/statis/bar.do",{'year':year},function(rs){
				if(rs.code != 200){
					layer.msg(rs.msg);
					return false;
				}
				//x轴值
				var xaxis = rs.data.xaxis;
				//图表系列数据
				var seriesData = rs.data.seriesData;
				//x轴赋值
				option.xAxis.data = xaxis;
				//为图表系列赋值
				option.series.data = seriesData;
				//渲染图表
				chart.setOption(option);
			}); 
			
		}).click();
	});


</script>
</body>
</html>