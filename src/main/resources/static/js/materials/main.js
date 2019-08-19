/*!
 */
"use strict";
//# sourceURL=main.js
 
// DOM 加载完再执行
//DOM 加载完再执行
$(function() {

    var _pageSize; // 存储用于搜索

    // 根据用户名、页面索引、页面大小获取用户列表
    function getMaterialByName(pageIndex, pageSize) {
         $.ajax({ 
             url: "/materials",
             contentType : 'application/json',
             data:{
                 "async":true, 
                 "pageIndex":pageIndex,
                 "pageSize":pageSize,
                 "materialName":$("#searchName").val()
             },
             success: function(data){
                 $("#mainContainer").html(data);
             },
             error : function() {
                 toastr.error("error!");
             }
         });
    }

    // 分页
    $.tbpage("#mainContainer", function (pageIndex, pageSize) {
        getMaterialByName(pageIndex, pageSize);
        _pageSize = pageSize;
    });

    // 搜索
    $("#searchNameBtn").click(function() {
        getMaterialByName(0, _pageSize);
    });

    // 获取添加用户的界面
    $("#addMaterial").click(function() {
        $.ajax({ 
             url: "/materials/add",
             success: function(data){
                 $("#materialFormContainer").html(data);
             },
             error : function(data) {
                 toastr.error("error!");
             }
         });
    });

    // 获取编辑用户的界面
    $("#rightContainer").on("click",".blog-edit-user", function () { 
        $.ajax({ 
             url: "/materials/edit/" + $(this).attr("materialId"),
             success: function(data){
                 $("#materialFormContainer").html(data);
             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 提交变更后，清空表单
    $("#submitEdit").click(function() {
        $.ajax({ 
             url: "/materials",
             type: 'POST',
             data:$('#materialForm').serialize(),
             success: function(data){
                 $('#materialForm')[0].reset();

                 if (data.success) {
                     // 从新刷新主界面
                     getMaterialByName(0, _pageSize);
                 } else {
                     toastr.error(data.message);
                 }

             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 删除用户
    $("#rightContainer").on("click",".blog-delete-user", function () { 

        $.ajax({ 
             url: "/materials/" + $(this).attr("materialId") ,
             type: 'DELETE', 
             success: function(data){
                 if (data.success) {
                     // 从新刷新主界面
                     getMaterialByName(0, _pageSize);
                 } else {
                     toastr.error(data.message);
                 }
             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 获取计算分数的界面
    $("#calculateMaterial").click(function() {
        $.ajax({
            cache: false,
            url: "/materials/calculate",
            success: function(data){
                $("#materialFormContainerForCalculate").html(data);
            },
            error : function(data) {
                toastr.error("error!");
            }

        });
    });
});