<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>年月销售额</title>
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
		option = {
			title: {
			        text: '年度月销售额统计',
			        left: 'center'
			},
			tooltip : {
			        trigger: 'axis',
			    },
		    xAxis: {
		        type: 'category',
		        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月','9月','10月','11月','12月']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: {
		        data: [50000, 3000, 2000, 6000, 10000, 1330, 1320, 2000, 6000, 10000, 1330, 1320],
		        type: 'line'
		    }
		};
		$("#searchBtn").click(function(){
			var value = t.config.value;
			var year = $("#year").val();
			if(year == null || year == ''){
				year = new Date().getFullYear();
			}
			$.post("${cxt}/sys/statis/line.do",{'year':year},function(rs){
				if(rs.code != 200){
					layer.msg(rs.msg);
					return false;
				}
				//图表系列数据
				var seriesData = rs.data.seriesData;
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