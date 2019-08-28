/*!
 */
"use strict";
//# sourceURL=main.js
 
// DOM 加载完再执行
//DOM 加载完再执行
$(function() {

    var _pageSize; // 存储用于搜索

    // 根据用户名、页面索引、页面大小获取竞标项目列表
    function getProjectByName(pageIndex, pageSize) {
         $.ajax({ 
             url: "/projects",
             contentType : 'application/json',
             data:{
                 "async":true, 
                 "pageIndex":pageIndex,
                 "pageSize":pageSize,
                 "projectName":$("#searchName").val()
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
        getProjectByName(pageIndex, pageSize);
        _pageSize = pageSize;
    });

    // 搜索
    $("#searchNameBtn").click(function() {
        getProjectByName(0, _pageSize);
    });

    // 获取添加竞标项目的界面
    $("#addProject").click(function() {
        $.ajax({ 
             url: "/projects/add",
             success: function(data){
                 $("#projectFormContainer").html(data);
             },
             error : function(data) {
                 toastr.error("error!");
             }
         });
    });

    // 获取编辑竞标项目的界面
    $("#rightContainer").on("click",".blog-edit-user", function () { 
        $.ajax({ 
             url: "/projects/edit/" + $(this).attr("projectId"),
             success: function(data){
                 $("#projectFormContainer").html(data);
             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 提交变更后，清空表单
    $("#submitEdit").click(function() {
        $.ajax({ 
             url: "/projects",
             type: 'POST',
             data:$('#projectForm').serialize(),
             success: function(data){
                 $('#projectForm')[0].reset();

                 if (data.success) {
                     // 从新刷新主界面
                     getProjectByName(0, _pageSize);
                 } else {
                     toastr.error(data.message);
                 }

             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 删除竞标项目
    $("#rightContainer").on("click",".blog-delete-user", function () { 

        $.ajax({ 
             url: "/projects/" + $(this).attr("projectId") ,
             type: 'DELETE', 
             success: function(data){
                 if (data.success) {
                     // 从新刷新主界面
                     getProjectByName(0, _pageSize);
                 } else {
                     toastr.error(data.message);
                 }
             },
             error : function() {
                 toastr.error("error!");
             }
         });
    });

    // 获取随机供应商的界面
    $("#random").click(function() {
        $.ajax({
            cache: false,
            url: "/projects/random",
            success: function(data){
                $("#projectFormContainerForRandom").html(data);
            },
            error : function(data) {
                toastr.error("error!");
            }

        });
    });

    $("#print").click(function() {
        $.ajax({
            cache: false,
            url: "/projects/print",
            success: function(data){
                $("#mainContainer").html(data);
            },
            error : function(data) {
                toastr.error("error!");
            }
        });
    });

});