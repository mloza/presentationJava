package org.apache.jsp._005ferrors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("\t<title>Błąd!</title>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"robots\" content=\"none\">\n");
      out.write("\t\n");
      out.write("\t<!-- Mobile metas -->\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\">\n");
      out.write("\t\n");
      out.write("\t<!-- Global stylesheets -->\n");
      out.write("\t<link href=\"../css/reset.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"../css/common.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"../css/form.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"../css/standard.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t<link href=\"../css/special-pages.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t\n");
      out.write("\t<!-- Custom styles -->\n");
      out.write("\t<link href=\"../css/simple-lists.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\t\n");
      out.write("\t<!-- Favicon -->\n");
      out.write("\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"../favicon.ico\">\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"../favicon-large.png\">\n");
      out.write("\t\n");
      out.write("\t<!-- Generic libs -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/html5.js\"></script><!-- this has to be loaded before anything else -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/jquery-1.4.2.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<!-- Template core functions -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/common.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/standard.js\"></script>\n");
      out.write("\t<!--[if lte IE 8]><script type=\"text/javascript\" src=\"../js/standard.ie.js\"></script><![endif]-->\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/jquery.tip.js\"></script>\n");
      out.write("\t\n");
      out.write("\t<!-- Template custom styles libs -->\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/list.js\"></script>\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("    <body class=\"special-page error-bg red dark\">\n");
      out.write("<!-- The template uses conditional comments to add wrappers div for ie8 and ie7 - just add .ie or .ie7 prefix to your css selectors when needed -->\n");
      out.write("<!--[if lt IE 9]><div class=\"ie\"><![endif]-->\n");
      out.write("<!--[if lt IE 8]><div class=\"ie7\"><![endif]-->\n");
      out.write("\t\n");
      out.write("\t<section id=\"error-desc\">\n");
      out.write("\t\t\n");
      out.write("\t\t<ul class=\"action-tabs with-children-tip children-tip-left\">\n");
      out.write("\t\t\t<li><a href=\"javascript:history.back()\" title=\"Go back\"><img src=\"../images/icons/fugue/navigation-180.png\" width=\"16\" height=\"16\"></a></li>\n");
      out.write("\t\t\t<li><a href=\"javascript:window.location.reload()\" title=\"Reload page\"><img src=\"../images/icons/fugue/arrow-circle.png\" width=\"16\" height=\"16\"></a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t<div class=\"block-border\"><div class=\"block-content\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<h1>Admin</h1>\n");
      out.write("\t\t\t<div class=\"block-header\">Wystąpił błąd!</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<h2>Opis błędu</h2>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<h5>Message</h5>\n");
      out.write("\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMsg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("\n");
      out.write("\t\t</div></div>\n");
      out.write("\t</section>\n");
      out.write("\t\n");
      out.write("\t<section id=\"error-log\">\n");
      out.write("\t\t<div class=\"block-border\"><div class=\"block-content\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<h1>Error details</h1>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"fieldset grey-bg with-margin\">\n");
      out.write("\t\t\t\t<p><b>Message</b><br>\n");
      out.write("\t\t\t\tUndefined variable: test</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<ul class=\"picto-list\">\n");
      out.write("\t\t\t\t<li class=\"icon-tag-small\"><b>Php error level:</b> 256</li>\n");
      out.write("\t\t\t\t<li class=\"icon-doc-small\"><b>File:</b> Constellation/html/error.html</li>\n");
      out.write("\t\t\t\t<li class=\"icon-pin-small\"><b>Line:</b> 51</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<!--<h2>Stack backtrace</h2>\n");
      out.write("\t\t\t<ul class=\"picto-list icon-top with-line-spacing\">\n");
      out.write("\t\t\t\t<li><b>Constellation/html/error.html</b> @ line <b>64</b>: checkLoadData(array(5))</li>\n");
      out.write("\t\t\t\t<li><b>Constellation/html/error.html</b> @ line <b>68</b>: loadUser(42)</li>\n");
      out.write("\t\t\t\t<li><b>Constellation/html/error.html</b> @ line <b>72</b>: initUser()</li>\n");
      out.write("\t\t\t</ul>--><\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div></div>\n");
      out.write("\t</section>\n");
      out.write("\n");
      out.write("<!--[if lt IE 8]></div><![endif]-->\n");
      out.write("<!--[if lt IE 9]></div><![endif]-->\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
