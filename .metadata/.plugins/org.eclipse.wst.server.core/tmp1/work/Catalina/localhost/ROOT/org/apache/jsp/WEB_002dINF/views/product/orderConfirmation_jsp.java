/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.83
 * Generated at: 2022-10-27 07:04:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.vo.ProductVO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.net.URLDecoder;

public final class orderConfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/eclipse-jee-2020-06-R-win32-x86_64/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/springProduct/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/eclipse-jee-2020-06-R-win32-x86_64/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/springProduct/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1666247059660L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.or.ddit.vo.ProductVO");
    _jspx_imports_classes.add("java.math.BigDecimal");
    _jspx_imports_classes.add("java.net.URLDecoder");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody;

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
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
//스크립틀릿
	String Shipping_name = "";
	String Shipping_zipCode = "";
	String Shipping_country = "";
	String Shipping_addressName = "";
	String Shipping_shippingDate = "";
	String Shipping_cartId = "";

	Cookie[] cookies = request.getCookies();
	//쿠키의 개수만큼 반복
	for(int i=0;i<cookies.length;i++){
		Cookie thisCookie = cookies[i];
		//쿠키 이름 가져옴
// 		out.print(thisCookie.getName() + "<br />");
		//쿠키 값 가져옴
// 		out.print(URLDecoder.decode(thisCookie.getValue(),"UTF-8")+"<br />");
		if(thisCookie.getName().equals("Shipping_name")){
			Shipping_name = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
		if(thisCookie.getName().equals("Shipping_zipCode")){
			Shipping_zipCode = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
		if(thisCookie.getName().equals("Shipping_country")){
			Shipping_country = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
		if(thisCookie.getName().equals("Shipping_addressName")){
			Shipping_addressName = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
		if(thisCookie.getName().equals("Shipping_shippingDate")){
			Shipping_shippingDate = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
		if(thisCookie.getName().equals("Shipping_cartId")){
			Shipping_cartId = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
		}
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/resources/css/bootstrap.min.css\" />\r\n");
      out.write("<title>주문 정보</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- include 액션 태그 -->\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"jumbotron\">\r\n");
      out.write("		<!-- container : 이 안에 내용있다 -->\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<h1 class=\"display-3\">주문 정보</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<!-- --------------------주문 정보 시작-------------------- -->\r\n");
      out.write("	<div class=\"container col-8 alert alert-info\">\r\n");
      out.write("		<div class=\"text-center\">\r\n");
      out.write("			<h1>영수증</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- 고객 정보 시작 : cookie사용-->\r\n");
      out.write("		<div class=\"row justify-content-between\">\r\n");
      out.write("			<strong>배송 주소</strong><br />\r\n");
      out.write("			성명 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br />\r\n");
      out.write("			우편번호 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.zipCode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("<br />\r\n");
      out.write("			주소 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.addressName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp;\r\n");
      out.write("				  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.addressDetail}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&nbsp;\r\n");
      out.write("				  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.country}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"col-4\" align=\"right\">\r\n");
      out.write("			<p>\r\n");
      out.write("				<em>배송일 : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cartVO.shippingDate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</em>\r\n");
      out.write("			</p>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- 고객 정보 끝 -->\r\n");
      out.write("		<!-- 상품 정보 시작 : session 사용 -->\r\n");
      out.write("		<div>\r\n");
      out.write("			<table class=\"table table-hover\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th class=\"text-center\">상품명</th>\r\n");
      out.write("					<th class=\"text-center\">#</th>\r\n");
      out.write("					<th class=\"text-center\">가격</th>\r\n");
      out.write("					<th class=\"text-center\">소계</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");
//스크립틀릿
					double sum = 0;
					//세션의 이름인 cartlist를 통해 Product타입의 상품목록 리스트를 가져와보자
					ArrayList<ProductVO> cartList = 
						(ArrayList<ProductVO>)session.getAttribute("cartlist");
					//상품 목록을 하나씩 출력해보자
					for(int i=0;i<cartList.size();i++){
						ProductVO product = cartList.get(i);
						//얼마짜리를 몇 개 샀니? => 금액
						double total = product.getUnitPrice() * product.getQuantity();
						sum = sum + total;
						
						BigDecimal totalBig = new BigDecimal(total);
				
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td class=\"text-center\"><em>");
      out.print(product.getPname());
      out.write("</em></td>\r\n");
      out.write("					<td class=\"text-center\">");
      out.print(product.getQuantity());
      out.write("</td>\r\n");
      out.write("					<td class=\"text-center\">\r\n");
      out.write("						<!-- 샵 쉽표 샵샵샵, 머리 속에 쏙쏙쏙 -->\r\n");
      out.write("						");
      //  fmt:formatNumber
      org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
      boolean _jspx_th_fmt_005fformatNumber_005f0_reused = false;
      try {
        _jspx_th_fmt_005fformatNumber_005f0.setPageContext(_jspx_page_context);
        _jspx_th_fmt_005fformatNumber_005f0.setParent(null);
        // /WEB-INF/views/product/orderConfirmation.jsp(109,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f0.setValue(product.getUnitPrice());
        // /WEB-INF/views/product/orderConfirmation.jsp(109,6) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f0.setPattern("#,###");
        int _jspx_eval_fmt_005fformatNumber_005f0 = _jspx_th_fmt_005fformatNumber_005f0.doStartTag();
        if (_jspx_th_fmt_005fformatNumber_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f0);
        _jspx_th_fmt_005fformatNumber_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatNumber_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatNumber_005f0_reused);
      }
      out.write(" 원\r\n");
      out.write("					</td>\r\n");
      out.write("					<td class=\"text-center\">\r\n");
      out.write("						");
      //  fmt:formatNumber
      org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
      boolean _jspx_th_fmt_005fformatNumber_005f1_reused = false;
      try {
        _jspx_th_fmt_005fformatNumber_005f1.setPageContext(_jspx_page_context);
        _jspx_th_fmt_005fformatNumber_005f1.setParent(null);
        // /WEB-INF/views/product/orderConfirmation.jsp(112,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f1.setValue(totalBig);
        // /WEB-INF/views/product/orderConfirmation.jsp(112,6) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f1.setPattern("#,###");
        int _jspx_eval_fmt_005fformatNumber_005f1 = _jspx_th_fmt_005fformatNumber_005f1.doStartTag();
        if (_jspx_th_fmt_005fformatNumber_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f1);
        _jspx_th_fmt_005fformatNumber_005f1_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatNumber_005f1, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatNumber_005f1_reused);
      }
      out.write(" 원\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

					}
					//크게 다시말해봐
					BigDecimal bdm = new BigDecimal(sum);
				
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td></td>\r\n");
      out.write("					<td></td>\r\n");
      out.write("					<td class=\"text-right\"><strong>총액:</strong></td>\r\n");
      out.write("					<td class=\"text-center text-danger\"><strong>\r\n");
      out.write("						");
      //  fmt:formatNumber
      org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_005fformatNumber_005f2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
      boolean _jspx_th_fmt_005fformatNumber_005f2_reused = false;
      try {
        _jspx_th_fmt_005fformatNumber_005f2.setPageContext(_jspx_page_context);
        _jspx_th_fmt_005fformatNumber_005f2.setParent(null);
        // /WEB-INF/views/product/orderConfirmation.jsp(125,6) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f2.setValue(bdm);
        // /WEB-INF/views/product/orderConfirmation.jsp(125,6) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_fmt_005fformatNumber_005f2.setPattern("#,###");
        int _jspx_eval_fmt_005fformatNumber_005f2 = _jspx_th_fmt_005fformatNumber_005f2.doStartTag();
        if (_jspx_th_fmt_005fformatNumber_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005ffmt_005fformatNumber_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatNumber_005f2);
        _jspx_th_fmt_005fformatNumber_005f2_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatNumber_005f2, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatNumber_005f2_reused);
      }
      out.write("원\r\n");
      out.write("					</strong></td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("			\r\n");
      out.write("			<a href=\"/shippingInfo?cartId=");
      out.print(Shipping_cartId);
      out.write("\"\r\n");
      out.write("			class=\"btn btn-secondary\" role=\"button\">이전</a>\r\n");
      out.write("			<a href=\"/thankCustomer\" class=\"btn btn-success\"\r\n");
      out.write("			role=\"button\">주문 완료</a>\r\n");
      out.write("			<a href=\"/checkOutCancelled\" class=\"btn btn-secondary\"\r\n");
      out.write("			role=\"button\">취소</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<!-- 상품 정보 끝 -->\r\n");
      out.write("	</div>\r\n");
      out.write("	<!-- --------------------주문 정보 끝-------------------- -->\r\n");
      out.write("	\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
