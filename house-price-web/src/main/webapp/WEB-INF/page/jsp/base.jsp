<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext['request'].contextPath}"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <script src="${contextPath}/resource/script/jquery-1.6.2.min.js" type="text/javascript"></script>
    <script src="${contextPath}/resource/script/commonUtils.js" type="text/javascript"></script>
    <script src="${contextPath}/resource/script/date.js" type="text/javascript"></script>
    <script src="${contextPath}/resource/script/jquery-ui-1.7.2.custom.min.js" type="text/javascript"></script>
    <script src="${contextPath}/resource/script/jquery-extend.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        correctPNG();
      });
      function correctPNG() {
        var arVersion = navigator.appVersion.split("MSIE");
        var version = parseFloat(arVersion[1]);
        if((version >= 5.5) && (document.body.filters)) {
          for(var j = 0; j < document.images.length; j ++) {
            var img = document.images[j];
            var imgName = img.src.toUpperCase();
            if(imgName.substring(imgName.length - 3, imgName.length) == "PNG") {
              var imgID = (img.id) ? "id='" + img.id + "' " : "";
              var imgClass = (img.className) ? "class='" + img.className + "' " : "";
              var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' ";
              var imgStyle = "display:inline-block;" + img.style.cssText;
              if(img.align == "left") {
                imgStyle = "float:left;" + imgStyle;
              }
              if(img.align == "right") {
                imgStyle = "float:right;" + imgStyle;
              }
              if(img.parentElement.href) {
                imgStyle = "cursor:hand;" + imgStyle;
              }
              var strNewHTML = "<span " + imgID + imgClass + imgTitle + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
                             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>";
              img.outerHTML = strNewHTML;
              j = j - 1;
            }
          }
        }    
      }
    </script>
  </head>
  <body>
  </body>
</html>