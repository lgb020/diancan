/*!
 * qcl
 */
"use strict";
//# sourceURL=main.js
// DOM 加载完再执行
$(function () {
    //点击登录按钮
    $("#loginBtn").click(function () {
        login();
        console.log("点击了登录")
    });

    //管理登录
    function login() {
        let phone = $(" input[ name='username' ] ").val();
        let psw = $(" input[ name='password' ] ").val();
        if (phone == undefined || phone == "") {
            alert("请输入手机号");
            return;
        }
        if (psw == undefined || psw == "") {
            alert("请输入密码");
            return;
        }
        $.ajax({
            url: "/sell/admin/loginAdmin",
            data: {
                "phone": phone,
                "password": psw
            },
            success: function (data) {
                $("#mainContainer").html(data);
                console.log("登录成功", data);
                window.location.href = "/sell/seller/order/list";
            },
            error: function (err) {
                console.log("登录失败,用户名或者密码不正确", err);
                alert("登录失败,手机号或者密码不正确");
                toastr.error("error!");
            }
        });
    }

    // 分页
    // $.tbpage("#mainContainer", function (pageIndex, pageSize) {
    //     getUersByName(pageIndex, pageSize);
    //     _pageSize = pageSize;
    // });


    // 获取添加用户的界面
    // $("#addUser").click(function () {
    //     $.ajax({
    //         url: "/users/add",
    //         success: function (data) {
    //             $("#userFormContainer").html(data);
    //         },
    //         error: function (data) {
    //             toastr.error("error!");
    //         }
    //     });
    // });

    // 获取编辑用户的界面
    // $("#rightContainer").on("click", ".blog-edit-user", function () {
    //     $.ajax({
    //         url: "/users/edit/" + $(this).attr("userId"),
    //         success: function (data) {
    //             $("#userFormContainer").html(data);
    //         },
    //         error: function () {
    //             toastr.error("error!");
    //         }
    //     });
    // });

    // 提交变更后，清空表单
    // $("#submitEdit").click(function () {
    //     $.ajax({
    //         url: "/users",
    //         type: 'POST',
    //         data: $('#userForm').serialize(),
    //         success: function (data) {
    //             $('#userForm')[0].reset();
    //
    //             if (data.success) {
    //                 // 从新刷新主界面
    //                 getUersByName(0, _pageSize);
    //             } else {
    //                 toastr.error(data.message);
    //             }
    //
    //         },
    //         error: function () {
    //             toastr.error("error!");
    //         }
    //     });
    // });

    // 删除用户
    // $("#rightContainer").on("click", ".blog-delete-user", function () {
    //     // 获取 CSRF Token
    //     var csrfToken = $("meta[name='_csrf']").attr("content");
    //     var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    //     $.ajax({
    //         url: "/users/" + $(this).attr("userId"),
    //         type: 'DELETE',
    //         beforeSend: function (request) {
    //             request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token
    //         },
    //         success: function (data) {
    //             if (data.success) {
    //                 // 从新刷新主界面
    //                 getUersByName(0, _pageSize);
    //             } else {
    //                 toastr.error(data.message);
    //             }
    //         },
    //         error: function () {
    //             toastr.error("error!");
    //         }
    //     });
    // });
});