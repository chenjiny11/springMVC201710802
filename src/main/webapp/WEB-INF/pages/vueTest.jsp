<%--
  Created by IntelliJ IDEA.
  User: f4o823hv9
  Date: 2017/7/11
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var path = '${projectPath}';
</script>
<html>

<head>
    <title></title>
</head>
<body>

<div id="vueTest">{{vuedata}}</div>
<div >${projectPath}</div>

</body>
</html>
<script type="text/javascript" src=${projectPath}/source/js/vue/vue.js></script>
<script>
    new Vue({
        el: '#vueTest',
        data: {
            vuedata: path
        }
    })

</script>
