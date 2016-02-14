<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Example Front Controller</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="wrapper">
            <h1>Example post submission</h1>

            <form class="form" method="post" action="PropSysController">               
                <input type="hidden" name="page" value="submission">
                
                <textarea autofocus class="markdown" rows="10" name="markdown"></textarea>
                <br/><br/>
                <input class="button" type="submit" value="Submit" />
            </form>
            
        </div>
        
    </body>
</html>
