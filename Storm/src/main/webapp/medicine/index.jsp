<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/5
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品信息维护系统</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<table class="table table-hover">
    <thead align="center">
    <tr align="center">
        <th colspan="9">
            <form id="frm" action="medicines" method="post">
                处方类型:<select name="medicine.prescriptionId">
                <option value="">全部</option>
                <option value="1">西/成药</option>
                <option value="2">西药</option>
            </select>
                <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..."
                        type="button"> 查询
                </button>
            </form>
        </th>
    </tr>
    <tr>
        <th>全选<input type="checkbox" onclick="" name="checkAll" /></th>
        <th>序号</th>
        <th>编号</th>
        <th>药品名称</th>
        <th>规格</th>
        <th>收费类别</th>
        <th>采购价</th>
        <th>销售价</th>
        <th>生产厂家</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="#medicineList" var="g">
        <tr>
            <td><input type="checkbox" name="check" value="<s:property value="#g.Gno"/>" /></td>
            <td><s:property value="#g.id"/> </td>
            <td><s:property value="#g.medicineno"/> </td>
            <td><s:property value="#g.medicinename"/> </td>
            <td><s:property value="#g.medicinesize"/> </td>
            <td><s:property value="#g.prescriptionid"/> </td>
            <td><s:property value="#g.purchaseprice"/> </td>
            <td><s:property value="#g.price"/> </td>
            <td><s:property value="#g.manufacturerid"/> </td>
            <td><s:property value="#g.stasus"/> </td>
            <td><s:property value="#g.createdate"/> </td>
            <td><button type="button" class="btn btn-primary btn-sm ">修改</button> | <button type="button" class="btn btn-primary btn-sm ">删除</button></td>
        </tr>
    </s:iterator>
    <tr>
        <th colspan="9">
            <input type="button" id="deleteAll" value="批量删除" />
        </th>
    </tr>
    </tbody>
</table>
<div class="container">
    <ul class="pagination pagination-lg">
        <li><a href="medicines?pageNo=<s:property value="%{pageNo-1}"/>">«</a></li>
        <s:iterator begin="1" end="#pageCount" var="g">
            <li><a href="medicines?pageNo=<s:property value="#g"/>"><s:property value="#g"/></a></li>
        </s:iterator>
        <li><a href="medicines?pageNo=<s:property value="#pageCount"/>">»</a></li>

    </ul>
</div>
<a href="add.jsp">增加商品</a>

<%--<script type="text/javascript" src="../jquery-1.12.4.js"></script>--%>
<script>
    $(function(){
        $(".btn").click(function(){
            $(this).button('loading').delay(200).queue(function() {
                $("#frm").submit();
                // $(this).button('reset');
                // $(this).dequeue();
            });

        });
        //全选、反选
        $('input[name="checkAll"]').click(function(){
            if($(this).is(':checked')){
                $('input[name="check"]').each(function () {
                    $(this).prop("checked",true);
                });
            } else {
                $('input[name="check"]').each(function () {
                    $(this).prop("checked",false);
                });
            }
        });

        //批量删除
        $("#deleteAll").click(function(){
            var Gnos = new Array();
            $("input[name='check']:checked").each(function() {
                Gnos.push($(this).val());
            });
            if(Gnos.length==0){
                alert("没有选中");
                return;
            }
            $.ajax({
                url:'/goodsdeleteAll',
                type:'post',
                data:{'Gnos':Gnos.toString()},
                success:function (data) {
                    window.location.reload();
                }
            });
        });

    });

</script>
</body>
</html>