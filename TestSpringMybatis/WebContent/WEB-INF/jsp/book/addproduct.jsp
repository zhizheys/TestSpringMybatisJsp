<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
<form:form action="product_save" method="post" commandName="product" enctype="multipart/form-data">
    <fieldset>
        <legend>Add a Product</legend>
        <p>
            <label for="name">ProductName</label>
            <form:input type="text" id="name" name="name" tabindex="1" path="name"/>
        </p>
        <p>
            <label for="description">ProductDescription</label>
            <form:input type="text" id="description" name="description" tabindex="2" path="description"/>
        </p>
        <p>
            <label for="price">ProductPrice</label>
            <form:input type="text" id="price" name="price" tabindex="3" path="price"/>
        </p>
        <p>
            <label for="image">ProductImage</label>
            <input type="file" name="images[0]" />
            <input type="file" name="images[1]" />
            <input type="file" name="images[2]" />
            
        </p>
        <p>
            <input type="reset">
            <input type="submit">
        </p>
    </fieldset>
</form:form>
</body>
</html>