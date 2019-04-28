# 后台技术选型：
- JDK8
- MySQL
- Spring-boot
- Spring-data-jpa
- Lombok
- Freemarker
- Bootstrap
- Websocket

# 小程序端技术选型
- 微信小程序

# 老规矩先看效果图
### 管理后台
![菜品管理](https://upload-images.jianshu.io/upload_images/6273713-928017278f465cbd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![订单管理](https://upload-images.jianshu.io/upload_images/6273713-4edede33faa7ea72.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
小程序下单完成后会有消息推送，如下
![消息推送](https://upload-images.jianshu.io/upload_images/6273713-2391a83091740991.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
可以直接操作订单
![操作订单](https://upload-images.jianshu.io/upload_images/6273713-5b25bd1e569113e3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 小程序端
![小程序端功能](https://upload-images.jianshu.io/upload_images/6273713-8d6c2b81701d32cd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
如上图，目前实现了如下功能。
- 扫码点餐
- 菜品分类显示
- 模拟支付
- 评论系统

下面说下使用流程
### 一，找老师索要源码，或者到老师微信公号回复“点餐小程序”获取源码
老师微信：2501902696
老师公号：
![编程小石头](https://upload-images.jianshu.io/upload_images/6273713-0a02e8e618d96535.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 二，导入java代码
- 1，我的java开发工具是IntelliJ IDEA，最好和我保持一致
- 2，如果你不知道如何导入java源码到idea，可以看下下面视频教程。
[https://edu.csdn.net/course/play/23443/265597](https://edu.csdn.net/course/play/23443/265597)

### 三，创建数据表格
导入源码成功后，执行下图的sql语句，建表
![sql语句建表](https://upload-images.jianshu.io/upload_images/6273713-44c40e53d4d191f1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
我是用IntelliJ IDEA自带的建表工具进行快速建表和管理表的
![idea自带mysql管理工具](https://upload-images.jianshu.io/upload_images/6273713-f24a49164d90705c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
如果你想用idea自带的管理工具，可以看下面这个视频：
[https://edu.csdn.net/course/play/23443/268165](https://edu.csdn.net/course/play/23443/268165)

### 四，修改配置
只需要把mysql数据库的账号和密码改成你的就行了。
![image.png](https://upload-images.jianshu.io/upload_images/6273713-8b9b83fbaf4fde27.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### 五，在seller_info表里创建一个管理员用于登录管理后台
![创建管理员](https://upload-images.jianshu.io/upload_images/6273713-09e0b9c4b329d02c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

---
#小程序代码
### 一，导入源码到小程序开发工具
![image.png](https://upload-images.jianshu.io/upload_images/6273713-78a2e556b1a65726.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
你如果没有小程序开发基础，只需要看下这个视频学习下如何导入小程序源码到开发者工具即可
[https://edu.csdn.net/course/play/9531/234418](https://edu.csdn.net/course/play/9531/234418)

### 二，导入成功后直接就可以用了
> 如果你想用扫码点餐，就把下面注释打开

![真机调试才可以扫码点餐](https://upload-images.jianshu.io/upload_images/6273713-5e4b91caa68e0148.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![扫码点餐代码](https://upload-images.jianshu.io/upload_images/6273713-2637e6bd904eec0b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 三，如果要扫码点餐的话，就扫码下面二维码。识别桌号
![image.png](https://upload-images.jianshu.io/upload_images/6273713-d213da9873e4cebd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

到这里我们java后台+点餐小程序实现就可以了。
如果导入代码中有任何问题可以加我微信：2501902696（备注编程）
![image.png](https://upload-images.jianshu.io/upload_images/6273713-c1e83a9b2c2dc441.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)









