<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Pharmative &mdash; Colorlib Template</title>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <link
      href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="<c:url value="/resources/fonts/icomoon/style.css"/>" />

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/resources/fonts/flaticon/font/flaticon.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/magnific-popup.css"/>" />
    <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.min.css"/>" />
    <link rel="stylesheet" href="<c:url value="/resources/css/owl.theme.default.min.css" />"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/aos.css" />"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
  </head>

  <body>
    <div class="site-wrap">
      <div class="site-navbar py-2">
        <div class="search-wrap">
          <div class="container">
            <a href="#" class="search-close js-search-close"
              ><span class="icon-close2"></span
            ></a>
            <form action="#" method="post">
              <input
                type="text"
                class="form-control"
                placeholder="Search keyword and hit enter..."
              />
            </form>
          </div>
        </div>

        <div class="container">
          <div class="d-flex align-items-center justify-content-between">
            <div class="logo">
              <div class="site-logo">
                <a href="index.jsp" class="js-logo-clone"
                  ><strong class="text-primary">Pharma</strong>tive</a
                >
              </div>
            </div>
            <div class="main-nav d-none d-lg-block" style="margin-left: 500px">
              <nav
                class="site-navigation text-right text-md-center"
                role="navigation"
              >
                <ul class="site-menu js-clone-nav d-none d-lg-block">
                  <li><a href="index.jsp">Home</a></li>
                  <li class="active"><a href="shop.jsp">Store</a></li>
                  <li class="has-children">
                    <a href="#">Products</a>
                    <ul class="dropdown">
                      <li><a href="#">Supplements</a></li>
                      <li class="has-children">
                        <a href="#">Vitamins</a>
                        <ul class="dropdown">
                          <li><a href="#">Supplements</a></li>
                          <li><a href="#">Vitamins</a></li>
                          <li><a href="#">Diet &amp; Nutrition</a></li>
                          <li><a href="#">Tea &amp; Coffee</a></li>
                        </ul>
                      </li>
                      <li><a href="#">Diet &amp; Nutrition</a></li>
                      <li><a href="#">Tea &amp; Coffee</a></li>
                    </ul>
                  </li>
                  <!-- <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li> -->
                </ul>
              </nav>
            </div>
            <div class="icons">
              <a href="#" class="icons-btn d-inline-block js-search-open"
                ><span class="icon-search"></span
              ></a>
              <a href="cart.jsp" class="icons-btn d-inline-block bag">
                <span class="icon-shopping-bag"></span>
                <span class="number">2</span>
              </a>
              <a
                href="#"
                class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"
                ><span class="icon-menu"></span
              ></a>
            </div>
          </div>
        </div>
      </div>

      <div class="bg-light py-3">
        <div class="container">
          <div class="row">
            <div class="col-md-12 mb-0">
              <a href="index.jsp">Home</a> <span class="mx-2 mb-0">/</span>
              <strong class="text-black">Thank You</strong>
            </div>
          </div>
        </div>
      </div>

      <div class="site-section">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-center">
              <span class="icon-check_circle display-3 text-primary"></span>
              <h2 class="display-3 text-black">Thank you!</h2>
              <p class="lead mb-5">You order was successfuly completed.</p>
              <p>
                <a
                  href="shop.jsp"
                  class="btn btn-md height-auto px-4 py-3 btn-primary"
                  >Back to store</a
                >
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- <footer class="site-footer bg-light">
        <div class="container">
          <div class="row">
            <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
              <div class="block-7">
                <h3 class="footer-heading mb-4">
                  About <strong class="text-primary">Pharmative</strong>
                </h3>
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius
                  quae reiciendis distinctio voluptates sed dolorum excepturi
                  iure eaque, aut unde.
                </p>
              </div>
            </div>
            <div class="col-lg-3 mx-auto mb-5 mb-lg-0">
              <h3 class="footer-heading mb-4">Navigation</h3>
              <ul class="list-unstyled">
                <li><a href="#">Supplements</a></li>
                <li><a href="#">Vitamins</a></li>
                <li><a href="#">Diet &amp; Nutrition</a></li>
                <li><a href="#">Tea &amp; Coffee</a></li>
              </ul>
            </div>

            <div class="col-md-6 col-lg-3">
              <div class="block-5 mb-5">
                <h3 class="footer-heading mb-4">Contact Info</h3>
                <ul class="list-unstyled">
                  <li class="address">
                    203 Fake St. Mountain View, San Francisco, California, USA
                  </li>
                  <li class="phone">
                    <a href="tel://23923929210">+2 392 3929 210</a>
                  </li>
                  <li class="email">emailaddress@domain.com</li>
                </ul>
              </div>
            </div>
          </div>
          <div class="row pt-5 mt-5 text-center">
            <div class="col-md-12">
              <p>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
      <!-- Copyright &copy;
                <script>
                  document.write(new Date().getFullYear());
                </script>
                All rights reserved | This template is made with
                <i class="icon-heart text-danger" aria-hidden="true"></i> by
                <a
                  href="https://colorlib.com"
                  target="_blank"
                  class="text-primary"
                  >Colorlib</a
                > -->
      <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
      <!-- </p>
            </div>
          </div>
        </div>
      </footer> -->
      <footer
        style="
          padding: 10px 10px 10px 10px;
          margin-left: 480px;
          color: black;
          font-weight: bold;
        "
      >
        Project created by Group 1 &copy;
      </footer>
    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/aos.js"></script>

    <script src="js/main.js"></script>
  </body>
</html>
