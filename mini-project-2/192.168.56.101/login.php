

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags always come first -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-light bg-faded" role="navigation">
                <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse" data-target="#collapsing-navbar">
                    &#9776;
                </button>
                <span class="navbar-brand">ImageShare</span>
                <div class="collapse navbar-toggleable-xs" id="collapsing-navbar">
                    <ul class="nav navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index.php">Home</a>
                        </li>
                             <li class="nav-item hidden-lg-up">
                            <a class="nav-link" href="login.php">Login</a>
                        </li>
                        <li class="nav-item hidden-lg-up">
                            <a class="nav-link" href="register.php">Register</a>
                        </li>
                        <form id="login-form" class="form-inline pull-xs-right hidden-md-down" method="post">
                            <div class="form-group">
                                <input placeholder="username" type="text" class="form-control" name="username">
                            </div>
                            <div class="form-group">
                                <input placeholder="password" type="password" class="form-control" name="password">
                            </div>
                            <button class="btn btn-success-outline" formaction="login.php">Login</button>
                            <button class="btn btn-success-outline" formaction="register.php">Register</button>
                        </form>
                        </ul>
                </div>
                </nav>
            <script type="text/javascript">
                function update_filename(src, target){
                    var fullPath = document.getElementById(src).value;
                    if (fullPath) {
                        var startIndex = (fullPath.indexOf('\\') >= 0 ? fullPath.lastIndexOf('\\') : fullPath.lastIndexOf('/'));
                        var filename = fullPath.substring(startIndex);
                        if (filename.indexOf('\\') === 0 || filename.indexOf('/') === 0) {
                            filename = filename.substring(1);
                        }
                        document.getElementById(target).value = filename;
                    }
                }
            </script>

<div class="row">
    <div class="col-sm-6 col-sm-offset-3">
        <form action="login.php" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input
                    id="username"
                    type="text"
                    class="form-control"
                    name="username"
                >
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input
                    id="password"
                    type="password"
                    class="form-control"
                    name="password"
                >
            </div>
            <button class="btn btn-success" type="submit">Login</button>
        </form>


    </div>
</div>

        </div>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js"></script>
    </body>
</html>
