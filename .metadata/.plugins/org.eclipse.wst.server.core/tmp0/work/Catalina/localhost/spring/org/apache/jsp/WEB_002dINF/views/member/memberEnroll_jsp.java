/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-06-16 03:07:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberEnroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<style>\r\n");
      out.write("	#container{width:500px; margin:auto;}\r\n");
      out.write("	th, td{height:30px;}\r\n");
      out.write("	input{width:250px;}\r\n");
      out.write("	.guide {display:none;}\r\n");
      out.write("	.ok {color:green;}\r\n");
      out.write("	.error {color:red;}\r\n");
      out.write("</style>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("회원가입", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("	<div id=\"container\">\r\n");
      out.write("		<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberEnroll.me\" method=\"post\" name=\"enrollfrm\">\r\n");
      out.write("			<table class=\"table\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"col\">아이디</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input name=\"userId\" placeholder=\"4글자이상\" id=\"userId\" required>\r\n");
      out.write("						<span class=\"guide ok\">아이디 사용가능</span>\r\n");
      out.write("						<span class=\"guide error\">아이디 사용불가</span>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"col\">비밀번호</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input type=\"password\" name=\"userPwd\" placeholder=\"영문,특수문자 포함\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th scope=\"col\">비밀번호 확인</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input type=\"password\" name=\"pwdCheck\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("					<th scope=\"col\">이름</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input name=\"userName\" placeholder=\"한글로 2글자 이상\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("					<th scope=\"col\">이메일</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input type=\"email\" name=\"email\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("					<th scope=\"col\">생년월일</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input type=\"date\" name=\"birthday\" required>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("					<th scope=\"col\">전화번호</th>\r\n");
      out.write("					<td scope=\"col\">\r\n");
      out.write("						<input name=\"phone\" placeholder=\"010-1234-5678\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			<button class=\"btn btn-outline-success\" type=\"submit\" >회원가입</button>&emsp;\r\n");
      out.write("			<button class=\"btn btn-outline-success\" type=\"reset\">초기화</button>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		document.querySelector(\"#userId\").addEventListener(\"keyup\",(e) => { //문서가 올라오면 바로 실행\r\n");
      out.write("			console.log(e.target.value);\r\n");
      out.write("			const userId = e.target;\r\n");
      out.write("			if(userId.value.length < 4) {\r\n");
      out.write("				ok.style.display = \"none\";\r\n");
      out.write("				error.style.display = \"none\";\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			const ok = document.querySelector(\".ok\"); //클래스 이름이 ok인 것\r\n");
      out.write("			const error = document.querySelector(\".error\");\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/checkId.do\",\r\n");
      out.write("				data : {userId : userId.value},\r\n");
      out.write("				dataType : \"json\",\r\n");
      out.write("				success(result) {\r\n");
      out.write("					console.log(result);\r\n");
      out.write("					const {userId, available} = result; //언팩킹: 각각의 변수에 담아주는 것()\r\n");
      out.write("					\r\n");
      out.write("					if(available) {\r\n");
      out.write("						ok.style.display = \"inline\";\r\n");
      out.write("						error.style.display = \"none\";\r\n");
      out.write("					} else {\r\n");
      out.write("						ok.style.display = \"none\";\r\n");
      out.write("						error.style.display = \"inline\";\r\n");
      out.write("					}\r\n");
      out.write("				},\r\n");
      out.write("				error : console.log\r\n");
      out.write("			});\r\n");
      out.write("		}); \r\n");
      out.write("	</script>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
