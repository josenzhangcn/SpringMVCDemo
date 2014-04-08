<html>
<head>
    <title>${appTitle}</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="/coffee/javascript/index.js"></script>
    <link type="text/css" rel="stylesheet" href="/coffee/css/style.css"/>
</head>
<body>
<form method="post" target="/coffee/home">
    ${appTitle}
    <table style="line-height: 20px; font-size: 12px;">
        <tr>
            <td>No.</td>
            <td><input type="text" name="number" autofocus="true" maxlength="10"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" maxlength="10"/></td>
        </tr>
        <tr>
            <td>Level</td>
            <td><select name="level">
                <option title="Normal" value="NORMAL">Normal</option>
                <option title="Silver" value="SILVER">Silver</option>
                <option title="Golden" value="GOLDEN">Golden</option>
            </select></td>
        </tr>
    </table>
    <input type="submit" value="${appTitle}"/>
</form>
</body>
</html>