<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户的分布</title>
<!-- 1.引入  layui相关文件  css 文件  -->
<link rel="stylesheet" href="${cxt}/resources/layui/css/layui.css"  />
</head>
<body>
<div id="pieContent" style="width: 500px;height:500px"></div>


<!-- 2. 引入echarts js -->
<script type="text/javascript" src="${cxt}/resources/layui/layui.js"></script>
<script type="text/javascript" src="${cxt}/resources/echarts.js"></script>
<script type="text/javascript">
	layui.use(['jquery','layer'],function(){
		var $ = layui.jquery;
		var layer = layui.layer;
		// 初始化echart 对象
		var chart = echarts.init(document.getElementById('pieContent'));
		
		// 图表的参数
		var option = {
			    title: {
			        text: '客户分布统计',
			        left: 'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        bottom: 10,
			        left: 'center',
			        data: null,
			    },
			    series : 
			        {   name:'客户占比',
			            type: 'pie',
			            radius : '65%',
			            center: ['50%', '50%'],
			            selectedMode: 'single',
			            data:null
			        }
			    
			};
		
		$.post("${cxt}/sys/statis/pie.do",function(rs){
			if(rs.code != 200){
				layer.msg(rs.msg);
				return false;
			}
			debugger;
			//获取图例数据
			var legendData = rs.data.legendData;
			//图表系列数据
			var seriesData = rs.data.seriesData;
			//为图例赋值
			option.legend.data = legendData;
			//为图表系列赋值
			option.series.data = seriesData;
			//渲染图表
			chart.setOption(option);
		});
	});


</script>
</body>
</html>