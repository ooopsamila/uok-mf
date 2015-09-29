<!DOCTYPE html>
<!-- saved from url=(0064)http://ironsummitmedia.github.io/startbootstrap-business-casual/ -->
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Diya Dahara</title>

    <!-- Bootstrap Core CSS -->
    <link href="themes/orange/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="themes/orange/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="themes/orange/css/css" rel="stylesheet" type="text/css">
    <link href="themes/orange/css/css(1)" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="brand">Diya Dahara</div>
<div class="address-bar">Lake Round Road | Kurunegala | +94372223452</div>

<!-- Navigation -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
            <a class="navbar-brand" href="welcome.html">Diya Dahara</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="welcome.html">Home</a>
                </li>
                <li>
                    <a href="room.html">Rooms</a>
                </li>
                <li>
                    <a href="food.html">Food</a>
                </li>
                <li>
                    <a href="table.html">Table</a>
                </li>
                <li>
                    <a href="tour.html">Tour</a>
                </li>
                <li>
                    <a href="contact.html">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="container">

    <div class="row">
        <div class="box">
            <form class="form-horizontal" action="checkIn.html" id="checkInForm" method="post">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-10">
                        <input type="text" required="required" class="form-control" id="name" placeholder="Name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" placeholder="Email" name="email">
                    </div>
                </div>

                <div class="form-group">
                    <label for="nic" class="col-sm-2 control-label">NIC/Passport</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nic" placeholder="NIC/Passport" name="nic">
                    </div>
                </div>

                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">Mobile Number</label>
                    <div class="col-sm-10">
                        <input type="text" required="required" class="form-control" id="telephone" placeholder="Mobile Number" name="telephone">
                    </div>
                </div>

                <div class="form-group">
                    <label for="country" class="col-sm-2 control-label">Country</label>
                    <div class="col-sm-10">
                        <select id = "country" name="country" class="form-control">
                            <option>Sri Lanka</option>
                            <option>US</option>
                            <option>UAE</option>
                            <option>India</option>
                            <option>Pakistan</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Check in</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright © pradeepika.herath2011@gmail.com</p>
                </div>
            </div>
        </div>
    </footer>
</div>
<!-- jQuery -->
<script src="themes/orange/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="themes/orange/js/bootstrap.min.js"></script>

<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>


</body>
</html>