drop sequence bs_user_id;
drop sequence bs_book_id;
drop sequence bs_category_id;
drop sequence bs_address_id;
drop sequence bs_order_id;
drop sequence bs_orderitem_id;

create sequence bs_user_id;
create sequence bs_book_id;
create sequence bs_category_id;
create sequence bs_address_id;
create sequence bs_order_id;
create sequence bs_orderitem_id;


drop table bs_orderitem;
drop table bs_order;
drop table bs_address;
drop table bs_user;
drop table bs_book;
drop table bs_category;

--用户表
create table bs_user(
	userid 		number(7) 		primary key,
	username 	varchar2(30) 	not null unique,
	password 	varchar2(30) 	not null,
	email 		varchar2(30),
	phone 		varchar2(20),
	company 	varchar2(30)
);


--书籍分类表
create table bs_category(
	cateid 		number(7) 		primary key,
	catename 	varchar2(20)
);

--书籍信息表
create table bs_book(
	bookid 			number(7) 		primary key,
	isbn 			varchar2(30) 	not null,
	name 			varchar2(50) 	not null,
	author 			varchar2(50) 	not null,
	publishHouse 	varchar2(30) 	not null,
	publishDate 	date,
	oldPrice 		number(5,2),
	newPrice 		number(5,2),
	authorLoc 		varchar2(30),
	info 			varchar2(255),
	imageurl 		varchar2(100),
	suit 			varchar2(20),
	category_id 	number(7),
	constraint 	bs_book_category_id_fk foreign key(category_id) 
	references bs_category(cateid)
);

--收货地址
create table bs_address(
	addressid 		number(7) 		primary key,
	area 			varchar2(40),
	detailaddress 	varchar2(30),
	emailcode 		varchar2(30),
	reciver 		varchar2(30),
	tel 			varchar2(30),
	isDefault 		char(1),
	auser_id 		number(7)
);

--订单
create table bs_order(
	orderId 		number(7) 		primary key,
	orderNum 		varchar2(40),
	createDate 		date,
	orderStatus 	varchar2(20),
	ouser_id 		number(7),
	address_id 		number(7),
	total   number(7,2)
);

--订单明细
create table bs_orderItem(
	itemId 			number(7) 		primary key,
	book_isbn 		varchar2(30),
	book_name 		varchar2(30),
	book_author 	varchar2(30),
	unit_price 		number(7,2),
	book_url 		varchar2(100),
	count 			number(7),
  	allPrice 		number(7,2),
	order_id 		number(7)
);


--初始化数据
insert into bs_category values(bs_category_id.nextval,'精选图书');
insert into bs_category values(bs_category_id.nextval,'推荐图书');
insert into bs_category values(bs_category_id.nextval,'特价图书');

INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787533946418','北纬78°',39.0,19.5,'浙江文艺出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','陈丹燕','中国',1,'一个作家，一本书，激起你行走的渴望，改变你旅行的意义。陈丹燕旅行文学。','beiwei78.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787513911139','100の大人味发现°',50.0,34.5,'民主与建设出版社',"TO_DATE"('2016-11','rrrr-mm'),'不是套装','吴东龙','中国',2,'超文艺、超时尚、很全面的东京旅游指南！台湾销售超火！从文化和设计角度深度解读东京，并提供完美的游览、住宿和美食攻略！', '100dongjindarenweifaxian.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787535477101','别走，万一好笑呢°',35.0,26.30,'长江文艺出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','银教授','中国',3,'微博人气博主@银教授个人作品集 银教授本人含泪自荐，希望你排着队拿着笑的号码牌，按顺序笑', 'biezouwanyihaoxiaone.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787550019775','此刻花开°',68.0,34.30,'百花洲文艺出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','徐静','中国',3,'一场轻松自由的创作体验！风靡全球的纸雕艺术，比《秘密花园》更给力的减压新玩法。虽然我们不断被这个世界雕刻着，但我们亦可以雕刻出一个世界！', 'cikehuakai.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787516413999','洞见°',48.0,34.60,'企业管理出版社',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','项保华','中国',2,'通过揭示体现在决策初心、判断、选择、落实背后的人性特征与事物规律，为提升个体及组织的决策管理水平与能力提供实用的操作指导。', 'dongjian.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787308164207','腾讯传°',58.0,40.10,'浙江大学出版社',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','吴晓波','中国',1,'全景式记录腾讯成长轨迹，回望一代人的互联网情怀，解读中国互联网企业领先全球的真正秘密。', 'tenxunchuan.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787550293151','拉普拉斯的魔女°',39.8,28.7,'北京联合出版公司',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','东野圭吾','日本',3,'东野圭吾：“我想摧毁自己以前写的小说，于是，这部作品就此诞生。” ', 'lapulasidemonv.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787540478612','愿你的青春不负梦想',36.0,21.60,'湖南文艺出版社',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','俞敏洪','中国',3,'50年心路历程×25年创业思考×80场演讲精华，与不甘平庸的你，谈谈如何度过不悔的青春，实现你心中的梦想。', 'yuannideqingchunbufumengxiang.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787540478612','情商高，就是说话让人舒服',38.0,19.00,'延边大学出版社',"TO_DATE"('2016-10','rrrr-mm'),'不是套装','朱凌,常清','中国',3,'教你洞悉人性、说话动听！所谓情商高，就是会说话。不拆台不揭短，不生硬不伤人，让你的每一句话都说得得体又令人舒服，到哪都受欢迎！', 'qingshanggaojiushishuohuarangrenshufu.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787507838992','销售心理战',36.8,18.40,'中国国际广播出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','霍金斯','英国',1,'销售就是察言、观色、攻心，销售就是要搞定人，各界的销售大师们强烈推崇的销售心理学！', 'xiaoshouxinlizhan.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787535448569','小道理：分寸之间',42,33.10,'长江文艺出版社',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','冯仑','中国',2,'商界精英的时代沉思录，地产导师的人生理想国。', 'xiaodaolifencunzhijian.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787508667836','名创优品没有秘密',36,27,'中信出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','杜博奇','中国',2,'经济寒冬中的一匹黑马，关店浪潮下的逆势崛起！全面解读名创优品的商业模式，还原一个真实的零售世界！', 'NO SECRETS.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787538890433','写给年轻人的创业课',39.8,19.9,'黑龙江科学技术出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','彭帅兴','中国',3,'每一个怀揣梦想的创业者都应该细读的暖心之作“拿来即用”的实战经验，“一针见血”的创业指导！', 'xiegeinianqinrende1.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787201111728','运营笔记',39.8,19.9,'天津人民出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','类延昊','中国',1,'猫扑网辉煌时代缔造者之一类类告诉你：如何在互联网运营下半场到来之前，快速成长，实现运营人生的弯道超车。 ', 'yunyinbiji.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787221135506','太空',38,45.5,'贵州人民出版社',"TO_DATE"('2016-11','rrrr-mm'),'不是套装','亚历山德拉·米热林斯卡','波兰',2,'浩瀚宇宙万千奇观，《太空》带你探索发现！本书献给喜欢仰望星空的少年科学家和梦想家！ ', 'taikong.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787113215491','欧洲',38,29.3,'中国铁道出版社',"TO_DATE"('2016-05','rrrr-mm'),'不是套装','《亲历者》编辑部','波兰',3,'旅行达人实地感受，29项欧洲体验式旅行；全方位文化解读，你的欧洲之旅*精彩。', 'ouzhou.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787519219420','西藏',39.8,19.9,'世界图书出版公司',"TO_DATE"('2017-1','rrrr-mm'),'不是套装','梅里','中国',1,'西藏，一个可以改变人生的地方骑行，一种可以征服世界的方式不出门，你不知道你能走多远；不流泪，你不知道你有多坚强。', 'xizang.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787201111735','我与世界只差一个你',49.0,38.7,'天津人民出版社',"TO_DATE"('2016-12','rrrr-mm'),'不是套装','张皓宸','中国',2,'12个温馨治愈的情感故事，给年轻人爱的正能量和信心，让你在面对爱时无惧，怀疑爱时坚定。', 'woyushijiezhichayigeni.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787515818122','卖产品就是卖自己',35.0,17.5,'中华工商联合出版社',"TO_DATE"('2016-11','rrrr-mm'),'不是套装','梁汉桥','中国',3,'销售就是要玩转情商，销售就是要有效化解客户问题，销售就是要搞定人', 'maichanpinjiushimaiziji.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787555106920','男孩的冒险书',198,99,'广西科学技术出版社',"TO_DATE"('2016-11','rrrr-mm'),'不是套装','康恩·伊古尔登','英国',1,'有史以来给男孩的完美手册升级！英国作者献给小男子汉的重磅手绘大作！原版连续12周《纽约时报》排行榜冠军，《时代周刊》鼎力推荐！', 'nanhaidemaoxianshu.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787507544824','美联储主席',58,29,'华文出版社',"TO_DATE"('2017-03','rrrr-mm'),'不是套装','斯凯恩','美国',2,'美联储主席又称“影子总统”，他们的权力美国第二，但全球NO.1。美元加不加息，他们说了算！他们讲话时，全球都得竖起耳朵听！', 'meilianchuzhuxi.jpg');
INSERT INTO bs_book(BOOKID,ISBN,NAME,OLDPRICE,NEWPRICE,PUBLISHHOUSE,PUBLISHDATE,SUIT,AUTHOR,AUTHORLOC,category_id,INFO,IMAGEURL)
					VALUES(bs_book_id.nextval,'9787550295179','我只想一个人住在你心里',45,32,'北京联合出版公司',"TO_DATE"('2017-01','rrrr-mm'),'不是套装','孟瑞','中国',3,'孟瑞首部青春成长暖伤图文故事集，记录那些走过的青春，爱的人，追的梦，未走完的路和苍茫人世寻觅心安抚慰的你我！', 'wozhixiangyigerenzainixinli.jpg');

commit;