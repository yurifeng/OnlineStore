<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书详情</title>
<link type="text/css" rel="stylesheet"
	href="${base}/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${base}/css/index.css" />
<link rel="stylesheet" type="text/css" href="${base}/css/animate.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/page/comm/header.jsp"></jsp:include>



	<!--外层div-->
	<div class="container">
		<!--左边-->
		<div class="col-md-8 col-sm-12">
			<ol class="breadcrumb">
				<li><a href="#">图书详情</a></li>
				<li><a href="#">${bk.name}</a></li>
			</ol>

			<div class="row">
				<div class="col-sm-12 col-md-6">
					<div class="thumbnail">
						<a><img src="${base}/images/${bk.imageurl}"
							style="height: 200px;" alt="通用的占位符缩略图"></a>
						<div class="caption">
							<h3>${bk.name}</h3>
							<p>
								双十一特价,包邮哟!亲<img src="${base}/images/3.gif"
									style="width: 24px; height: 24px;">
							</p>
							<p>
							<div style="margin-bottom: 5px; width: 100px;">
								<input id="counts" type="number" value="1" class="form-control"
									placeholder="购买数量" min="1" max="99" maxlength="2"
									onclick="selectByCount(this)">
							</div>
							<div style="clear: both;">
								<!--<input type="number" class="form-control" placeholder="请输入" min="1" max="100" onclick="selectByCount(this)">-->
								<a href="javascript:addCart(${bk.bookid},true)"
									class="btn btn-default" role="button"> <span
									class="glyphicon glyphicon-usd"></span> 立即购买
								</a> <a href="javascript:addCart(${bk.bookid},false)"
									class="btn btn-default" role="button"> <span
									class="glyphicon glyphicon-shopping-cart"></span> 加入购物车
								</a>
							</div>

						</div>
					</div>
				</div>

				<div class="col-sm-12 col-md-6">
					<div class="thumbnail">
						<ul class="list-group">
							<li class="list-group-item"><span class="text-success">图书名称:</span>${bk.name}</li>
							<li class="list-group-item"><span class="text-info">作者:</span>${bk.author}</li>
							<li class="list-group-item"><span class="text-info">出版日期:</span>
								<fmt:formatDate value='${bk.publishDate}' pattern='yyyy-MM-dd' /></li>
							<li class="list-group-item"><span class="text-info">出版社:</span>${bk.publishHouse}</li>
							<li class="list-group-item"><span class="text-info"
								style="text-decoration: line-through;">原价:</span><span
								style="text-decoration: line-through;">${bk.oldPrice}元</span></li>
							<li class="list-group-item"><span class="text-info">现价:</span>${bk.newPrice}元</li>
							<li class="list-group-item"><span class="text-info">说明:</span>
								${bk.info}</li>
						</ul>
					</div>
				</div>
			</div>
			<!--<hr>-->
			<!--折叠部分 begin-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseTwo"> 展开详细信息 </a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse">
					<div class="panel-body">
						<!--tab选项卡 begin-->
						<ul id="myTab" class="nav nav-tabs">
							<li class="active"><a href="#home" data-toggle="tab">
									商品详情 </a></li>
							<li><a href="#ios" data-toggle="tab"> <span
									class="badge pull-right">50</span>累计评价
							</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane fade in active" id="home">
								<p>
									<em>产品参数：</em>
								</p>
								<div class="row">
									<p>
									<div class="col-sm-12 col-md-6">
										<ul class="nav navbar-collapse" style="line-height: 3;">
											<li class="text-info">产品名称：${bk.name}</li>
											<li class="text-info">是否是套装: ${bk.suit}</li>
											<li class="text-info">书名:${bk.name}</li>
											<li class="text-info">定价: ${bk.oldPrice}</li>
											<li class="text-info">出版社名称:${bk.publishHouse}</li>
											<li class="text-info">出版时间:<fmt:formatDate
													value='${bk.publishDate}' pattern='yyyy-MM-dd' /></li>
											<li class="text-info">作者: ${bk.author}</li>
											<li class="text-info">作者地区: ${bk.authorLoc}</li>
											<li class="text-info">ISBN编号: ${bk.isbn}</li>
										</ul>
									</div>
									<span class="visible-sm visible-xs">
										<hr />
									</span>

								</div>
								</p>
							</div>
							<div class="tab-pane fade" id="ios">
								<p>
								<ul class="list-group">
									<li class="list-group-item"><span class="text-info">小明:</span><span
										class="text-success ">这真的是一本好书<img
											src="${base}/images/emotions/1.gif "></span></li>
									<li class="list-group-item"><span class="text-info">success:</span><span
										class="text-danger ">书的质量很差<img
											src="${base}/images/emotions/2.gif "></span></li>
									<li class="list-group-item"><span class="text-info">叶老师:</span><span
										class="text-success ">很值得初学者学习<img
											src="${base}/images/emotions/13.gif "></span></li>
									<li class="list-group-item"><span class="text-info">amdin:</span><span
										class="text-danger ">被坑大发了.<img
											src="${base}/images/emotions/17.gif "></span></li>
									<li class="list-group-item"><span class="text-info">rose:</span><span
										class="text-danger ">卖家态度恶劣.<img
											src="${base}/images/emotions/11.gif "></span></li>
								</ul>
								</p>
								<p>
								<ul class="pager">
									<li><a href="# ">&larr;上一页</a> <a href="# ">下一页 &rarr;</a>
									</li>
								</ul>
								</p>
							</div>
						</div>
						<!--tab选项卡 end-->
					</div>
				</div>
			</div>
			<!--折叠部分end-->
		</div>
		<div id="rightData">
			<jsp:include page="/WEB-INF/page/comm/righter.jsp"></jsp:include>
		</div>


	</div>


	<%@ include file="/WEB-INF/page/comm/footer.html"%>



	<script src="${base}/dist/js/jquery.min.js"></script>
	<script src="${base}/js/wow.js"></script>
	<script src="${base}/js/carousel.js" type="text/javascript"></script>
	<script src="${base}/dist/js/bootstrap.min.js"></script>
	<script src="${base}/js/details.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript">
		if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
			new WOW().init();
		};

		function addCart(id, immite) {
			var count = document.getElementById("counts").value;

			if (count.length > 2) {
				alert("最多只能买99本");
				return;
			}

			$
					.get(
							"${base}/permission/cart/addCart?id=" + id
									+ "&count=" + count,
							function(data, status) {
								if (status == 'success') {

									if (data == 1) {

										if (immite) {
											window.location.href = "${base}/permission/order/index?pageid=1";
										} else {
											$("#rightData").load(
													"${base}/book/right");
										}
									} else if (data == 3) {
										alert("请输入正确的购买数量");
									} else {
										window.location.href = "/Book_Store/user/info?info=1";
									}

								}
							});
		}
	</script>
</body>
</html>