<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>

<head>
    <title>选择图标</title>
	<jsp:include page="../../page/common/taglib.jsp"></jsp:include>
	<script type="text/javascript">
	$(function(){
		$('a').on('click',function(){  
		    $('#icon', window.parent.document).html($(this).children('i').prop("outerHTML"));
		    $('#icon_img', window.parent.document).val($(this).children('i').prop("outerHTML"));
		    window.parent.layer.closeAll();
		});  
	});
	</script>
</head>

<body class="gray-bg">
               <section id="new">
                   <div class="row fontawesome-icon-list col-md-6">
                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-500px"></i> 500px</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-amazon"></i> amazon</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-balance-scale"></i> balance-scale</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-0"></i> battery-0 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-1"></i> battery-1 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-2"></i> battery-2 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-3"></i> battery-3 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-4"></i> battery-4 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-empty"></i> battery-empty</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-full"></i> battery-full</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-half"></i> battery-half</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-quarter"></i> battery-quarter</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-battery-three-quarters"></i> battery-three-quarters</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-black-tie"></i> black-tie</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-calendar-check-o"></i> calendar-check-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-calendar-minus-o"></i> calendar-minus-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-calendar-plus-o"></i> calendar-plus-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-calendar-times-o"></i> calendar-times-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-cc-diners-club"></i> cc-diners-club</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-cc-jcb"></i> cc-jcb</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-chrome"></i> chrome</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-clone"></i> clone</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-commenting"></i> commenting</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-commenting-o"></i> commenting-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-contao"></i> contao</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-creative-commons"></i> creative-commons</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-expeditedssl"></i> expeditedssl</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-firefox"></i> firefox</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-fonticons"></i> fonticons</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-genderless"></i> genderless</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-get-pocket"></i> get-pocket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-gg"></i> gg</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-gg-circle"></i> gg-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-grab-o"></i> hand-grab-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-lizard-o"></i> hand-lizard-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-paper-o"></i> hand-paper-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-peace-o"></i> hand-peace-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-pointer-o"></i> hand-pointer-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-rock-o"></i> hand-rock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-scissors-o"></i> hand-scissors-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-spock-o"></i> hand-spock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hand-stop-o"></i> hand-stop-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass"></i> hourglass</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:; "><i class="fa fa-hourglass-1"></i> hourglass-1 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-2"></i> hourglass-2 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-3"></i> hourglass-3 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-end"></i> hourglass-end</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-half"></i> hourglass-half</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-o"></i> hourglass-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-hourglass-start"></i> hourglass-start</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-houzz"></i> houzz</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-i-cursor"></i> i-cursor</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-industry"></i> industry</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-internet-explorer"></i> internet-explorer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-map"></i> map</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-map-o"></i> map-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-map-pin"></i> map-pin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-map-signs"></i> map-signs</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-mouse-pointer"></i> mouse-pointer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-object-group"></i> object-group</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-object-ungroup"></i> object-ungroup</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-odnoklassniki"></i> odnoklassniki</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-odnoklassniki-square"></i> odnoklassniki-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-opencart"></i> opencart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-opera"></i> opera</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-optin-monster"></i> optin-monster</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-registered"></i> registered</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-safari"></i> safari</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-sticky-note"></i> sticky-note</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-sticky-note-o"></i> sticky-note-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-television"></i> television</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-trademark"></i> trademark</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-tripadvisor"></i> tripadvisor</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-tv"></i> tv <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-vimeo"></i> vimeo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-wikipedia-w"></i> wikipedia-w</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-y-combinator"></i> y-combinator</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;"><i class="fa fa-yc"></i> yc <span class="text-muted">(alias)</span></a></div>

                   </div>

               </section>
               <section id="web-application">
                   <h2 class="page-header">Web应用程序图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">
                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;adjust"><i class="fa fa-adjust"></i> adjust</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;anchor"><i class="fa fa-anchor"></i> anchor</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;archive"><i class="fa fa-archive"></i> archive</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;area-chart"><i class="fa fa-area-chart"></i> area-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows"><i class="fa fa-arrows"></i> arrows</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-h"><i class="fa fa-arrows-h"></i> arrows-h</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-v"><i class="fa fa-arrows-v"></i> arrows-v</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;asterisk"><i class="fa fa-asterisk"></i> asterisk</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;at"><i class="fa fa-at"></i> at</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;car"><i class="fa fa-automobile"></i> automobile <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;balance-scale"><i class="fa fa-balance-scale"></i> balance-scale</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ban"><i class="fa fa-ban"></i> ban</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;university"><i class="fa fa-bank"></i> bank <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bar-chart"><i class="fa fa-bar-chart"></i> bar-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bar-chart"><i class="fa fa-bar-chart-o"></i> bar-chart-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;barcode"><i class="fa fa-barcode"></i> barcode</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bars"><i class="fa fa-bars"></i> bars</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-empty"><i class="fa fa-battery-0"></i> battery-0 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-quarter"><i class="fa fa-battery-1"></i> battery-1 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-half"><i class="fa fa-battery-2"></i> battery-2 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-three-quarters"><i class="fa fa-battery-3"></i> battery-3 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-full"><i class="fa fa-battery-4"></i> battery-4 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-empty"><i class="fa fa-battery-empty"></i> battery-empty</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-full"><i class="fa fa-battery-full"></i> battery-full</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-half"><i class="fa fa-battery-half"></i> battery-half</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-quarter"><i class="fa fa-battery-quarter"></i> battery-quarter</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;battery-three-quarters"><i class="fa fa-battery-three-quarters"></i> battery-three-quarters</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bed"><i class="fa fa-bed"></i> bed</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;beer"><i class="fa fa-beer"></i> beer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bell"><i class="fa fa-bell"></i> bell</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bell-o"><i class="fa fa-bell-o"></i> bell-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bell-slash"><i class="fa fa-bell-slash"></i> bell-slash</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bell-slash-o"><i class="fa fa-bell-slash-o"></i> bell-slash-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bicycle"><i class="fa fa-bicycle"></i> bicycle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;binoculars"><i class="fa fa-binoculars"></i> binoculars</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;birthday-cake"><i class="fa fa-birthday-cake"></i> birthday-cake</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bolt"><i class="fa fa-bolt"></i> bolt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bomb"><i class="fa fa-bomb"></i> bomb</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;book"><i class="fa fa-book"></i> book</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bookmark"><i class="fa fa-bookmark"></i> bookmark</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bookmark-o"><i class="fa fa-bookmark-o"></i> bookmark-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;briefcase"><i class="fa fa-briefcase"></i> briefcase</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bug"><i class="fa fa-bug"></i> bug</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;building"><i class="fa fa-building"></i> building</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;building-o"><i class="fa fa-building-o"></i> building-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bullhorn"><i class="fa fa-bullhorn"></i> bullhorn</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bullseye"><i class="fa fa-bullseye"></i> bullseye</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bus"><i class="fa fa-bus"></i> bus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;taxi"><i class="fa fa-cab"></i> cab <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calculator"><i class="fa fa-calculator"></i> calculator</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar"><i class="fa fa-calendar"></i> calendar</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar-check-o"><i class="fa fa-calendar-check-o"></i> calendar-check-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar-minus-o"><i class="fa fa-calendar-minus-o"></i> calendar-minus-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar-o"><i class="fa fa-calendar-o"></i> calendar-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar-plus-o"><i class="fa fa-calendar-plus-o"></i> calendar-plus-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;calendar-times-o"><i class="fa fa-calendar-times-o"></i> calendar-times-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;camera"><i class="fa fa-camera"></i> camera</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;camera-retro"><i class="fa fa-camera-retro"></i> camera-retro</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;car"><i class="fa fa-car"></i> car</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-down"><i class="fa fa-caret-square-o-down"></i> caret-square-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-left"><i class="fa fa-caret-square-o-left"></i> caret-square-o-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-right"><i class="fa fa-caret-square-o-right"></i> caret-square-o-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-up"><i class="fa fa-caret-square-o-up"></i> caret-square-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cart-arrow-down"><i class="fa fa-cart-arrow-down"></i> cart-arrow-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cart-plus"><i class="fa fa-cart-plus"></i> cart-plus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc"><i class="fa fa-cc"></i> cc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;certificate"><i class="fa fa-certificate"></i> certificate</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check"><i class="fa fa-check"></i> check</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-circle"><i class="fa fa-check-circle"></i> check-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-circle-o"><i class="fa fa-check-circle-o"></i> check-circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-square"><i class="fa fa-check-square"></i> check-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-square-o"><i class="fa fa-check-square-o"></i> check-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;child"><i class="fa fa-child"></i> child</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle"><i class="fa fa-circle"></i> circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle-o"><i class="fa fa-circle-o"></i> circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle-o-notch"><i class="fa fa-circle-o-notch"></i> circle-o-notch</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle-thin"><i class="fa fa-circle-thin"></i> circle-thin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;clock-o"><i class="fa fa-clock-o"></i> clock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;clone"><i class="fa fa-clone"></i> clone</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;times"><i class="fa fa-close"></i> close <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cloud"><i class="fa fa-cloud"></i> cloud</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cloud-download"><i class="fa fa-cloud-download"></i> cloud-download</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cloud-upload"><i class="fa fa-cloud-upload"></i> cloud-upload</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;code"><i class="fa fa-code"></i> code</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;code-fork"><i class="fa fa-code-fork"></i> code-fork</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;coffee"><i class="fa fa-coffee"></i> coffee</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cog"><i class="fa fa-cog"></i> cog</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cogs"><i class="fa fa-cogs"></i> cogs</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;comment"><i class="fa fa-comment"></i> comment</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;comment-o"><i class="fa fa-comment-o"></i> comment-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;commenting"><i class="fa fa-commenting"></i> commenting</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;commenting-o"><i class="fa fa-commenting-o"></i> commenting-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;comments"><i class="fa fa-comments"></i> comments</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;comments-o"><i class="fa fa-comments-o"></i> comments-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;compass"><i class="fa fa-compass"></i> compass</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;copyright"><i class="fa fa-copyright"></i> copyright</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;creative-commons"><i class="fa fa-creative-commons"></i> creative-commons</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;credit-card"><i class="fa fa-credit-card"></i> credit-card</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;crop"><i class="fa fa-crop"></i> crop</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;crosshairs"><i class="fa fa-crosshairs"></i> crosshairs</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cube"><i class="fa fa-cube"></i> cube</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cubes"><i class="fa fa-cubes"></i> cubes</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cutlery"><i class="fa fa-cutlery"></i> cutlery</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tachometer"><i class="fa fa-dashboard"></i> dashboard <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;database"><i class="fa fa-database"></i> database</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;desktop"><i class="fa fa-desktop"></i> desktop</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;diamond"><i class="fa fa-diamond"></i> diamond</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;dot-circle-o"><i class="fa fa-dot-circle-o"></i> dot-circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;download"><i class="fa fa-download"></i> download</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pencil-square-o"><i class="fa fa-edit"></i> edit <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ellipsis-h"><i class="fa fa-ellipsis-h"></i> ellipsis-h</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ellipsis-v"><i class="fa fa-ellipsis-v"></i> ellipsis-v</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;envelope"><i class="fa fa-envelope"></i> envelope</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;envelope-o"><i class="fa fa-envelope-o"></i> envelope-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;envelope-square"><i class="fa fa-envelope-square"></i> envelope-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eraser"><i class="fa fa-eraser"></i> eraser</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exchange"><i class="fa fa-exchange"></i> exchange</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exclamation"><i class="fa fa-exclamation"></i> exclamation</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exclamation-circle"><i class="fa fa-exclamation-circle"></i> exclamation-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exclamation-triangle"><i class="fa fa-exclamation-triangle"></i> exclamation-triangle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;external-link"><i class="fa fa-external-link"></i> external-link</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;external-link-square"><i class="fa fa-external-link-square"></i> external-link-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eye"><i class="fa fa-eye"></i> eye</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eye-slash"><i class="fa fa-eye-slash"></i> eye-slash</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eyedropper"><i class="fa fa-eyedropper"></i> eyedropper</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fax"><i class="fa fa-fax"></i> fax</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rss"><i class="fa fa-feed"></i> feed <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;female"><i class="fa fa-female"></i> female</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fighter-jet"><i class="fa fa-fighter-jet"></i> fighter-jet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-archive-o"><i class="fa fa-file-archive-o"></i> file-archive-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-audio-o"><i class="fa fa-file-audio-o"></i> file-audio-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-code-o"><i class="fa fa-file-code-o"></i> file-code-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-excel-o"><i class="fa fa-file-excel-o"></i> file-excel-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-image-o"></i> file-image-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-video-o"><i class="fa fa-file-movie-o"></i> file-movie-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-pdf-o"><i class="fa fa-file-pdf-o"></i> file-pdf-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-photo-o"></i> file-photo-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-picture-o"></i> file-picture-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-powerpoint-o"><i class="fa fa-file-powerpoint-o"></i> file-powerpoint-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-audio-o"><i class="fa fa-file-sound-o"></i> file-sound-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-video-o"><i class="fa fa-file-video-o"></i> file-video-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-word-o"><i class="fa fa-file-word-o"></i> file-word-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-archive-o"><i class="fa fa-file-zip-o"></i> file-zip-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;film"><i class="fa fa-film"></i> film</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;filter"><i class="fa fa-filter"></i> filter</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fire"><i class="fa fa-fire"></i> fire</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fire-extinguisher"><i class="fa fa-fire-extinguisher"></i> fire-extinguisher</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;flag"><i class="fa fa-flag"></i> flag</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;flag-checkered"><i class="fa fa-flag-checkered"></i> flag-checkered</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;flag-o"><i class="fa fa-flag-o"></i> flag-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bolt"><i class="fa fa-flash"></i> flash <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;flask"><i class="fa fa-flask"></i> flask</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;folder"><i class="fa fa-folder"></i> folder</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;folder-o"><i class="fa fa-folder-o"></i> folder-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;folder-open"><i class="fa fa-folder-open"></i> folder-open</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;folder-open-o"><i class="fa fa-folder-open-o"></i> folder-open-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;frown-o"><i class="fa fa-frown-o"></i> frown-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;futbol-o"><i class="fa fa-futbol-o"></i> futbol-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gamepad"><i class="fa fa-gamepad"></i> gamepad</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gavel"><i class="fa fa-gavel"></i> gavel</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cog"><i class="fa fa-gear"></i> gear <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cogs"><i class="fa fa-gears"></i> gears <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gift"><i class="fa fa-gift"></i> gift</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;glass"><i class="fa fa-glass"></i> glass</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;globe"><i class="fa fa-globe"></i> globe</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;graduation-cap"><i class="fa fa-graduation-cap"></i> graduation-cap</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;users"><i class="fa fa-group"></i> group <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-rock-o"><i class="fa fa-hand-grab-o"></i> hand-grab-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-lizard-o"><i class="fa fa-hand-lizard-o"></i> hand-lizard-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-paper-o"><i class="fa fa-hand-paper-o"></i> hand-paper-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-peace-o"><i class="fa fa-hand-peace-o"></i> hand-peace-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-pointer-o"><i class="fa fa-hand-pointer-o"></i> hand-pointer-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-rock-o"><i class="fa fa-hand-rock-o"></i> hand-rock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-scissors-o"><i class="fa fa-hand-scissors-o"></i> hand-scissors-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-spock-o"><i class="fa fa-hand-spock-o"></i> hand-spock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-paper-o"><i class="fa fa-hand-stop-o"></i> hand-stop-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hdd-o"><i class="fa fa-hdd-o"></i> hdd-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;headphones"><i class="fa fa-headphones"></i> headphones</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heart"><i class="fa fa-heart"></i> heart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heart-o"><i class="fa fa-heart-o"></i> heart-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heartbeat"><i class="fa fa-heartbeat"></i> heartbeat</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;history"><i class="fa fa-history"></i> history</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;home"><i class="fa fa-home"></i> home</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bed"><i class="fa fa-hotel"></i> hotel <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass"><i class="fa fa-hourglass"></i> hourglass</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-start"><i class="fa fa-hourglass-1"></i> hourglass-1 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-half"><i class="fa fa-hourglass-2"></i> hourglass-2 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-end"><i class="fa fa-hourglass-3"></i> hourglass-3 <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-end"><i class="fa fa-hourglass-end"></i> hourglass-end</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-half"><i class="fa fa-hourglass-half"></i> hourglass-half</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-o"><i class="fa fa-hourglass-o"></i> hourglass-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hourglass-start"><i class="fa fa-hourglass-start"></i> hourglass-start</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;i-cursor"><i class="fa fa-i-cursor"></i> i-cursor</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;picture-o"><i class="fa fa-image"></i> image <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;inbox"><i class="fa fa-inbox"></i> inbox</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;industry"><i class="fa fa-industry"></i> industry</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;info"><i class="fa fa-info"></i> info</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;info-circle"><i class="fa fa-info-circle"></i> info-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;university"><i class="fa fa-institution"></i> institution <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;key"><i class="fa fa-key"></i> key</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;keyboard-o"><i class="fa fa-keyboard-o"></i> keyboard-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;language"><i class="fa fa-language"></i> language</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;laptop"><i class="fa fa-laptop"></i> laptop</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;leaf"><i class="fa fa-leaf"></i> leaf</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gavel"><i class="fa fa-legal"></i> legal <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;lemon-o"><i class="fa fa-lemon-o"></i> lemon-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;level-down"><i class="fa fa-level-down"></i> level-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;level-up"><i class="fa fa-level-up"></i> level-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;life-ring"><i class="fa fa-life-bouy"></i> life-bouy <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;life-ring"><i class="fa fa-life-buoy"></i> life-buoy <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;life-ring"><i class="fa fa-life-ring"></i> life-ring</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;life-ring"><i class="fa fa-life-saver"></i> life-saver <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;lightbulb-o"><i class="fa fa-lightbulb-o"></i> lightbulb-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;line-chart"><i class="fa fa-line-chart"></i> line-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;location-arrow"><i class="fa fa-location-arrow"></i> location-arrow</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;lock"><i class="fa fa-lock"></i> lock</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;magic"><i class="fa fa-magic"></i> magic</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;magnet"><i class="fa fa-magnet"></i> magnet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share"><i class="fa fa-mail-forward"></i> mail-forward <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reply"><i class="fa fa-mail-reply"></i> mail-reply <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reply-all"><i class="fa fa-mail-reply-all"></i> mail-reply-all <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;male"><i class="fa fa-male"></i> male</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;map"><i class="fa fa-map"></i> map</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;map-marker"><i class="fa fa-map-marker"></i> map-marker</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;map-o"><i class="fa fa-map-o"></i> map-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;map-pin"><i class="fa fa-map-pin"></i> map-pin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;map-signs"><i class="fa fa-map-signs"></i> map-signs</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;meh-o"><i class="fa fa-meh-o"></i> meh-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;microphone"><i class="fa fa-microphone"></i> microphone</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;microphone-slash"><i class="fa fa-microphone-slash"></i> microphone-slash</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus"><i class="fa fa-minus"></i> minus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus-circle"><i class="fa fa-minus-circle"></i> minus-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus-square"><i class="fa fa-minus-square"></i> minus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus-square-o"><i class="fa fa-minus-square-o"></i> minus-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mobile"><i class="fa fa-mobile"></i> mobile</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mobile"><i class="fa fa-mobile-phone"></i> mobile-phone <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;money"><i class="fa fa-money"></i> money</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;moon-o"><i class="fa fa-moon-o"></i> moon-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;graduation-cap"><i class="fa fa-mortar-board"></i> mortar-board <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;motorcycle"><i class="fa fa-motorcycle"></i> motorcycle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mouse-pointer"><i class="fa fa-mouse-pointer"></i> mouse-pointer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;music"><i class="fa fa-music"></i> music</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bars"><i class="fa fa-navicon"></i> navicon <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;newspaper-o"><i class="fa fa-newspaper-o"></i> newspaper-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;object-group"><i class="fa fa-object-group"></i> object-group</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;object-ungroup"><i class="fa fa-object-ungroup"></i> object-ungroup</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paint-brush"><i class="fa fa-paint-brush"></i> paint-brush</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paper-plane"><i class="fa fa-paper-plane"></i> paper-plane</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paper-plane-o"><i class="fa fa-paper-plane-o"></i> paper-plane-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paw"><i class="fa fa-paw"></i> paw</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pencil"><i class="fa fa-pencil"></i> pencil</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pencil-square"><i class="fa fa-pencil-square"></i> pencil-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pencil-square-o"><i class="fa fa-pencil-square-o"></i> pencil-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;phone"><i class="fa fa-phone"></i> phone</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;phone-square"><i class="fa fa-phone-square"></i> phone-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;picture-o"><i class="fa fa-photo"></i> photo <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;picture-o"><i class="fa fa-picture-o"></i> picture-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pie-chart"><i class="fa fa-pie-chart"></i> pie-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plane"><i class="fa fa-plane"></i> plane</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plug"><i class="fa fa-plug"></i> plug</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus"><i class="fa fa-plus"></i> plus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-circle"><i class="fa fa-plus-circle"></i> plus-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-square"><i class="fa fa-plus-square"></i> plus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-square-o"><i class="fa fa-plus-square-o"></i> plus-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;power-off"><i class="fa fa-power-off"></i> power-off</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;print"><i class="fa fa-print"></i> print</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;puzzle-piece"><i class="fa fa-puzzle-piece"></i> puzzle-piece</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;qrcode"><i class="fa fa-qrcode"></i> qrcode</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;question"><i class="fa fa-question"></i> question</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;question-circle"><i class="fa fa-question-circle"></i> question-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;quote-left"><i class="fa fa-quote-left"></i> quote-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;quote-right"><i class="fa fa-quote-right"></i> quote-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;random"><i class="fa fa-random"></i> random</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;recycle"><i class="fa fa-recycle"></i> recycle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;refresh"><i class="fa fa-refresh"></i> refresh</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;registered"><i class="fa fa-registered"></i> registered</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;times"><i class="fa fa-remove"></i> remove <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bars"><i class="fa fa-reorder"></i> reorder <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reply"><i class="fa fa-reply"></i> reply</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reply-all"><i class="fa fa-reply-all"></i> reply-all</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;retweet"><i class="fa fa-retweet"></i> retweet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;road"><i class="fa fa-road"></i> road</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rocket"><i class="fa fa-rocket"></i> rocket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rss"><i class="fa fa-rss"></i> rss</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rss-square"><i class="fa fa-rss-square"></i> rss-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;search"><i class="fa fa-search"></i> search</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;search-minus"><i class="fa fa-search-minus"></i> search-minus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;search-plus"><i class="fa fa-search-plus"></i> search-plus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paper-plane"><i class="fa fa-send"></i> send <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paper-plane-o"><i class="fa fa-send-o"></i> send-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;server"><i class="fa fa-server"></i> server</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share"><i class="fa fa-share"></i> share</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-alt"><i class="fa fa-share-alt"></i> share-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-alt-square"><i class="fa fa-share-alt-square"></i> share-alt-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-square"><i class="fa fa-share-square"></i> share-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-square-o"><i class="fa fa-share-square-o"></i> share-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;shield"><i class="fa fa-shield"></i> shield</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ship"><i class="fa fa-ship"></i> ship</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;shopping-cart"><i class="fa fa-shopping-cart"></i> shopping-cart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sign-in"><i class="fa fa-sign-in"></i> sign-in</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sign-out"><i class="fa fa-sign-out"></i> sign-out</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;signal"><i class="fa fa-signal"></i> signal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sitemap"><i class="fa fa-sitemap"></i> sitemap</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sliders"><i class="fa fa-sliders"></i> sliders</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;smile-o"><i class="fa fa-smile-o"></i> smile-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;futbol-o"><i class="fa fa-soccer-ball-o"></i> soccer-ball-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort"><i class="fa fa-sort"></i> sort</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-alpha-asc"><i class="fa fa-sort-alpha-asc"></i> sort-alpha-asc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-alpha-desc"><i class="fa fa-sort-alpha-desc"></i> sort-alpha-desc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-amount-asc"><i class="fa fa-sort-amount-asc"></i> sort-amount-asc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-amount-desc"><i class="fa fa-sort-amount-desc"></i> sort-amount-desc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-asc"><i class="fa fa-sort-asc"></i> sort-asc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-desc"><i class="fa fa-sort-desc"></i> sort-desc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-desc"><i class="fa fa-sort-down"></i> sort-down <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-numeric-asc"><i class="fa fa-sort-numeric-asc"></i> sort-numeric-asc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-numeric-desc"><i class="fa fa-sort-numeric-desc"></i> sort-numeric-desc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort-asc"><i class="fa fa-sort-up"></i> sort-up <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;space-shuttle"><i class="fa fa-space-shuttle"></i> space-shuttle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;spinner"><i class="fa fa-spinner"></i> spinner</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;spoon"><i class="fa fa-spoon"></i> spoon</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;square"><i class="fa fa-square"></i> square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;square-o"><i class="fa fa-square-o"></i> square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star"><i class="fa fa-star"></i> star</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star-half"><i class="fa fa-star-half"></i> star-half</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star-half-o"><i class="fa fa-star-half-empty"></i> star-half-empty <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star-half-o"><i class="fa fa-star-half-full"></i> star-half-full <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star-half-o"><i class="fa fa-star-half-o"></i> star-half-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;star-o"><i class="fa fa-star-o"></i> star-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sticky-note"><i class="fa fa-sticky-note"></i> sticky-note</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sticky-note-o"><i class="fa fa-sticky-note-o"></i> sticky-note-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;street-view"><i class="fa fa-street-view"></i> street-view</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;suitcase"><i class="fa fa-suitcase"></i> suitcase</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sun-o"><i class="fa fa-sun-o"></i> sun-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;life-ring"><i class="fa fa-support"></i> support <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tablet"><i class="fa fa-tablet"></i> tablet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tachometer"><i class="fa fa-tachometer"></i> tachometer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tag"><i class="fa fa-tag"></i> tag</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tags"><i class="fa fa-tags"></i> tags</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tasks"><i class="fa fa-tasks"></i> tasks</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;taxi"><i class="fa fa-taxi"></i> taxi</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;television"><i class="fa fa-television"></i> television</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;terminal"><i class="fa fa-terminal"></i> terminal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumb-tack"><i class="fa fa-thumb-tack"></i> thumb-tack</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-down"><i class="fa fa-thumbs-down"></i> thumbs-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-o-down"><i class="fa fa-thumbs-o-down"></i> thumbs-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-o-up"><i class="fa fa-thumbs-o-up"></i> thumbs-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-up"><i class="fa fa-thumbs-up"></i> thumbs-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ticket"><i class="fa fa-ticket"></i> ticket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;times"><i class="fa fa-times"></i> times</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;times-circle"><i class="fa fa-times-circle"></i> times-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;times-circle-o"><i class="fa fa-times-circle-o"></i> times-circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tint"><i class="fa fa-tint"></i> tint</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-down"><i class="fa fa-toggle-down"></i> toggle-down <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-left"><i class="fa fa-toggle-left"></i> toggle-left <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;toggle-off"><i class="fa fa-toggle-off"></i> toggle-off</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;toggle-on"><i class="fa fa-toggle-on"></i> toggle-on</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-right"><i class="fa fa-toggle-right"></i> toggle-right <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-up"><i class="fa fa-toggle-up"></i> toggle-up <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;trademark"><i class="fa fa-trademark"></i> trademark</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;trash"><i class="fa fa-trash"></i> trash</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;trash-o"><i class="fa fa-trash-o"></i> trash-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tree"><i class="fa fa-tree"></i> tree</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;trophy"><i class="fa fa-trophy"></i> trophy</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;truck"><i class="fa fa-truck"></i> truck</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tty"><i class="fa fa-tty"></i> tty</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;television"><i class="fa fa-tv"></i> tv <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;umbrella"><i class="fa fa-umbrella"></i> umbrella</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;university"><i class="fa fa-university"></i> university</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;unlock"><i class="fa fa-unlock"></i> unlock</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;unlock-alt"><i class="fa fa-unlock-alt"></i> unlock-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sort"><i class="fa fa-unsorted"></i> unsorted <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;upload"><i class="fa fa-upload"></i> upload</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;user"><i class="fa fa-user"></i> user</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;user-plus"><i class="fa fa-user-plus"></i> user-plus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;user-secret"><i class="fa fa-user-secret"></i> user-secret</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;user-times"><i class="fa fa-user-times"></i> user-times</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;users"><i class="fa fa-users"></i> users</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;video-camera"><i class="fa fa-video-camera"></i> video-camera</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;volume-down"><i class="fa fa-volume-down"></i> volume-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;volume-off"><i class="fa fa-volume-off"></i> volume-off</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;volume-up"><i class="fa fa-volume-up"></i> volume-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exclamation-triangle"><i class="fa fa-warning"></i> warning <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wheelchair"><i class="fa fa-wheelchair"></i> wheelchair</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wifi"><i class="fa fa-wifi"></i> wifi</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wrench"><i class="fa fa-wrench"></i> wrench</a></div>

                   </div>

               </section>
               <section id="hand">
                   <h2 class="page-header">手型图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-rock-o"><i class="fa fa-hand-grab-o"></i> hand-grab-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-lizard-o"><i class="fa fa-hand-lizard-o"></i> hand-lizard-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-down"><i class="fa fa-hand-o-down"></i> hand-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-left"><i class="fa fa-hand-o-left"></i> hand-o-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-right"><i class="fa fa-hand-o-right"></i> hand-o-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-up"><i class="fa fa-hand-o-up"></i> hand-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-paper-o"><i class="fa fa-hand-paper-o"></i> hand-paper-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-peace-o"><i class="fa fa-hand-peace-o"></i> hand-peace-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-pointer-o"><i class="fa fa-hand-pointer-o"></i> hand-pointer-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-rock-o"><i class="fa fa-hand-rock-o"></i> hand-rock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-scissors-o"><i class="fa fa-hand-scissors-o"></i> hand-scissors-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-spock-o"><i class="fa fa-hand-spock-o"></i> hand-spock-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-paper-o"><i class="fa fa-hand-stop-o"></i> hand-stop-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-down"><i class="fa fa-thumbs-down"></i> thumbs-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-o-down"><i class="fa fa-thumbs-o-down"></i> thumbs-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-o-up"><i class="fa fa-thumbs-o-up"></i> thumbs-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;thumbs-up"><i class="fa fa-thumbs-up"></i> thumbs-up</a></div>

                   </div>

               </section>

               <section id="transportation">
                   <h2 class="page-header">交通运输图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ambulance"><i class="fa fa-ambulance"></i> ambulance</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;car"><i class="fa fa-automobile"></i> automobile <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bicycle"><i class="fa fa-bicycle"></i> bicycle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bus"><i class="fa fa-bus"></i> bus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;taxi"><i class="fa fa-cab"></i> cab <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;car"><i class="fa fa-car"></i> car</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fighter-jet"><i class="fa fa-fighter-jet"></i> fighter-jet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;motorcycle"><i class="fa fa-motorcycle"></i> motorcycle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plane"><i class="fa fa-plane"></i> plane</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rocket"><i class="fa fa-rocket"></i> rocket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ship"><i class="fa fa-ship"></i> ship</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;space-shuttle"><i class="fa fa-space-shuttle"></i> space-shuttle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;subway"><i class="fa fa-subway"></i> subway</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;taxi"><i class="fa fa-taxi"></i> taxi</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;train"><i class="fa fa-train"></i> train</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;truck"><i class="fa fa-truck"></i> truck</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wheelchair"><i class="fa fa-wheelchair"></i> wheelchair</a></div>

                   </div>

               </section>
               <section id="gender">
                   <h2 class="page-header">性别图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;genderless"><i class="fa fa-genderless"></i> genderless</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;transgender"><i class="fa fa-intersex"></i> intersex <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mars"><i class="fa fa-mars"></i> mars</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mars-double"><i class="fa fa-mars-double"></i> mars-double</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mars-stroke"><i class="fa fa-mars-stroke"></i> mars-stroke</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mars-stroke-h"><i class="fa fa-mars-stroke-h"></i> mars-stroke-h</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mars-stroke-v"><i class="fa fa-mars-stroke-v"></i> mars-stroke-v</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;mercury"><i class="fa fa-mercury"></i> mercury</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;neuter"><i class="fa fa-neuter"></i> neuter</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;transgender"><i class="fa fa-transgender"></i> transgender</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;transgender-alt"><i class="fa fa-transgender-alt"></i> transgender-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;venus"><i class="fa fa-venus"></i> venus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;venus-double"><i class="fa fa-venus-double"></i> venus-double</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;venus-mars"><i class="fa fa-venus-mars"></i> venus-mars</a></div>

                   </div>

               </section>
               <section id="file-type">
                   <h2 class="page-header">文件类型图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file"><i class="fa fa-file"></i> file</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-archive-o"><i class="fa fa-file-archive-o"></i> file-archive-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-audio-o"><i class="fa fa-file-audio-o"></i> file-audio-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-code-o"><i class="fa fa-file-code-o"></i> file-code-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-excel-o"><i class="fa fa-file-excel-o"></i> file-excel-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-image-o"></i> file-image-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-video-o"><i class="fa fa-file-movie-o"></i> file-movie-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-o"><i class="fa fa-file-o"></i> file-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-pdf-o"><i class="fa fa-file-pdf-o"></i> file-pdf-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-photo-o"></i> file-photo-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-image-o"><i class="fa fa-file-picture-o"></i> file-picture-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-powerpoint-o"><i class="fa fa-file-powerpoint-o"></i> file-powerpoint-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-audio-o"><i class="fa fa-file-sound-o"></i> file-sound-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-text"><i class="fa fa-file-text"></i> file-text</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-text-o"><i class="fa fa-file-text-o"></i> file-text-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-video-o"><i class="fa fa-file-video-o"></i> file-video-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-word-o"><i class="fa fa-file-word-o"></i> file-word-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-archive-o"><i class="fa fa-file-zip-o"></i> file-zip-o <span class="text-muted">(alias)</span></a></div>

                   </div>

               </section>
               <section id="spinner">
                   <h2 class="page-header">加载动画图标</h2>

                   <div class="alert alert-success">
                       <ul class="fa-ul">
                           <li>
                               <i class="fa fa-info-circle fa-lg fa-li"></i> 给这些图标加上
                               <code>fa-spin</code> class，就可以表现出加载动画了
                           </li>
                       </ul>
                   </div>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle-o-notch"><i class="fa fa-circle-o-notch"></i> circle-o-notch</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cog"><i class="fa fa-cog"></i> cog</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cog"><i class="fa fa-gear"></i> gear <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;refresh"><i class="fa fa-refresh"></i> refresh</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;spinner"><i class="fa fa-spinner"></i> spinner</a></div>

                   </div>
               </section>
               <section id="form-control">
                   <h2 class="page-header">表单图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-square"><i class="fa fa-check-square"></i> check-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;check-square-o"><i class="fa fa-check-square-o"></i> check-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle"><i class="fa fa-circle"></i> circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;circle-o"><i class="fa fa-circle-o"></i> circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;dot-circle-o"><i class="fa fa-dot-circle-o"></i> dot-circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus-square"><i class="fa fa-minus-square"></i> minus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;minus-square-o"><i class="fa fa-minus-square-o"></i> minus-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-square"><i class="fa fa-plus-square"></i> plus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-square-o"><i class="fa fa-plus-square-o"></i> plus-square-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;square"><i class="fa fa-square"></i> square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;square-o"><i class="fa fa-square-o"></i> square-o</a></div>

                   </div>
               </section>
               <section id="payment">
                   <h2 class="page-header">支付图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-amex"><i class="fa fa-cc-amex"></i> cc-amex</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-diners-club"><i class="fa fa-cc-diners-club"></i> cc-diners-club</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-discover"><i class="fa fa-cc-discover"></i> cc-discover</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-jcb"><i class="fa fa-cc-jcb"></i> cc-jcb</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-mastercard"><i class="fa fa-cc-mastercard"></i> cc-mastercard</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-paypal"><i class="fa fa-cc-paypal"></i> cc-paypal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-stripe"><i class="fa fa-cc-stripe"></i> cc-stripe</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-visa"><i class="fa fa-cc-visa"></i> cc-visa</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;credit-card"><i class="fa fa-credit-card"></i> credit-card</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;google-wallet"><i class="fa fa-google-wallet"></i> google-wallet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paypal"><i class="fa fa-paypal"></i> paypal</a></div>

                   </div>

               </section>
               <section id="chart">
                   <h2 class="page-header">统计图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;area-chart"><i class="fa fa-area-chart"></i> area-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bar-chart"><i class="fa fa-bar-chart"></i> bar-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bar-chart"><i class="fa fa-bar-chart-o"></i> bar-chart-o <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;line-chart"><i class="fa fa-line-chart"></i> line-chart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pie-chart"><i class="fa fa-pie-chart"></i> pie-chart</a></div>

                   </div>

               </section>
               <section id="currency">
                   <h2 class="page-header">货币图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;btc"><i class="fa fa-bitcoin"></i> bitcoin <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;btc"><i class="fa fa-btc"></i> btc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;jpy"><i class="fa fa-cny"></i> cny <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;usd"><i class="fa fa-dollar"></i> dollar <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eur"><i class="fa fa-eur"></i> eur</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eur"><i class="fa fa-euro"></i> euro <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gbp"><i class="fa fa-gbp"></i> gbp</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gg"><i class="fa fa-gg"></i> gg</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gg-circle"><i class="fa fa-gg-circle"></i> gg-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ils"><i class="fa fa-ils"></i> ils</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;inr"><i class="fa fa-inr"></i> inr</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;jpy"><i class="fa fa-jpy"></i> jpy</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;krw"><i class="fa fa-krw"></i> krw</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;money"><i class="fa fa-money"></i> money</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;jpy"><i class="fa fa-rmb"></i> rmb <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rub"><i class="fa fa-rouble"></i> rouble <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rub"><i class="fa fa-rub"></i> rub</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rub"><i class="fa fa-ruble"></i> ruble <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;inr"><i class="fa fa-rupee"></i> rupee <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ils"><i class="fa fa-shekel"></i> shekel <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ils"><i class="fa fa-sheqel"></i> sheqel <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;try"><i class="fa fa-try"></i> try</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;try"><i class="fa fa-turkish-lira"></i> turkish-lira <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;usd"><i class="fa fa-usd"></i> usd</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;krw"><i class="fa fa-won"></i> won <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;jpy"><i class="fa fa-yen"></i> yen <span class="text-muted">(alias)</span></a></div>

                   </div>

               </section>
               <section id="text-editor">
                   <h2 class="page-header">文本编辑器图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;align-center"><i class="fa fa-align-center"></i> align-center</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;align-justify"><i class="fa fa-align-justify"></i> align-justify</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;align-left"><i class="fa fa-align-left"></i> align-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;align-right"><i class="fa fa-align-right"></i> align-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bold"><i class="fa fa-bold"></i> bold</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;link"><i class="fa fa-chain"></i> chain <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chain-broken"><i class="fa fa-chain-broken"></i> chain-broken</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;clipboard"><i class="fa fa-clipboard"></i> clipboard</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;columns"><i class="fa fa-columns"></i> columns</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;files-o"><i class="fa fa-copy"></i> copy <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;scissors"><i class="fa fa-cut"></i> cut <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;outdent"><i class="fa fa-dedent"></i> dedent <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eraser"><i class="fa fa-eraser"></i> eraser</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file"><i class="fa fa-file"></i> file</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-o"><i class="fa fa-file-o"></i> file-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-text"><i class="fa fa-file-text"></i> file-text</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;file-text-o"><i class="fa fa-file-text-o"></i> file-text-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;files-o"><i class="fa fa-files-o"></i> files-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;floppy-o"><i class="fa fa-floppy-o"></i> floppy-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;font"><i class="fa fa-font"></i> font</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;header"><i class="fa fa-header"></i> header</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;indent"><i class="fa fa-indent"></i> indent</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;italic"><i class="fa fa-italic"></i> italic</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;link"><i class="fa fa-link"></i> link</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;list"><i class="fa fa-list"></i> list</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;list-alt"><i class="fa fa-list-alt"></i> list-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;list-ol"><i class="fa fa-list-ol"></i> list-ol</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;list-ul"><i class="fa fa-list-ul"></i> list-ul</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;outdent"><i class="fa fa-outdent"></i> outdent</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paperclip"><i class="fa fa-paperclip"></i> paperclip</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paragraph"><i class="fa fa-paragraph"></i> paragraph</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;clipboard"><i class="fa fa-paste"></i> paste <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;repeat"><i class="fa fa-repeat"></i> repeat</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;undo"><i class="fa fa-rotate-left"></i> rotate-left <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;repeat"><i class="fa fa-rotate-right"></i> rotate-right <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;floppy-o"><i class="fa fa-save"></i> save <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;scissors"><i class="fa fa-scissors"></i> scissors</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;strikethrough"><i class="fa fa-strikethrough"></i> strikethrough</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;subscript"><i class="fa fa-subscript"></i> subscript</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;superscript"><i class="fa fa-superscript"></i> superscript</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;table"><i class="fa fa-table"></i> table</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;text-height"><i class="fa fa-text-height"></i> text-height</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;text-width"><i class="fa fa-text-width"></i> text-width</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;th"><i class="fa fa-th"></i> th</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;th-large"><i class="fa fa-th-large"></i> th-large</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;th-list"><i class="fa fa-th-list"></i> th-list</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;underline"><i class="fa fa-underline"></i> underline</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;undo"><i class="fa fa-undo"></i> undo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chain-broken"><i class="fa fa-unlink"></i> unlink <span class="text-muted">(alias)</span></a></div>

                   </div>

               </section>
               <section id="directional">
                   <h2 class="page-header">方向图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-double-down"><i class="fa fa-angle-double-down"></i> angle-double-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-double-left"><i class="fa fa-angle-double-left"></i> angle-double-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-double-right"><i class="fa fa-angle-double-right"></i> angle-double-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-double-up"><i class="fa fa-angle-double-up"></i> angle-double-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-down"><i class="fa fa-angle-down"></i> angle-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-left"><i class="fa fa-angle-left"></i> angle-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-right"><i class="fa fa-angle-right"></i> angle-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angle-up"><i class="fa fa-angle-up"></i> angle-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-down"><i class="fa fa-arrow-circle-down"></i> arrow-circle-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-left"><i class="fa fa-arrow-circle-left"></i> arrow-circle-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-o-down"><i class="fa fa-arrow-circle-o-down"></i> arrow-circle-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-o-left"><i class="fa fa-arrow-circle-o-left"></i> arrow-circle-o-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-o-right"><i class="fa fa-arrow-circle-o-right"></i> arrow-circle-o-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-o-up"><i class="fa fa-arrow-circle-o-up"></i> arrow-circle-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-right"><i class="fa fa-arrow-circle-right"></i> arrow-circle-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-circle-up"><i class="fa fa-arrow-circle-up"></i> arrow-circle-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-down"><i class="fa fa-arrow-down"></i> arrow-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-left"><i class="fa fa-arrow-left"></i> arrow-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-right"><i class="fa fa-arrow-right"></i> arrow-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrow-up"><i class="fa fa-arrow-up"></i> arrow-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows"><i class="fa fa-arrows"></i> arrows</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-alt"><i class="fa fa-arrows-alt"></i> arrows-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-h"><i class="fa fa-arrows-h"></i> arrows-h</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-v"><i class="fa fa-arrows-v"></i> arrows-v</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-down"><i class="fa fa-caret-down"></i> caret-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-left"><i class="fa fa-caret-left"></i> caret-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-right"><i class="fa fa-caret-right"></i> caret-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-down"><i class="fa fa-caret-square-o-down"></i> caret-square-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-left"><i class="fa fa-caret-square-o-left"></i> caret-square-o-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-right"><i class="fa fa-caret-square-o-right"></i> caret-square-o-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-up"><i class="fa fa-caret-square-o-up"></i> caret-square-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-up"><i class="fa fa-caret-up"></i> caret-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-circle-down"><i class="fa fa-chevron-circle-down"></i> chevron-circle-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-circle-left"><i class="fa fa-chevron-circle-left"></i> chevron-circle-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-circle-right"><i class="fa fa-chevron-circle-right"></i> chevron-circle-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-circle-up"><i class="fa fa-chevron-circle-up"></i> chevron-circle-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-down"><i class="fa fa-chevron-down"></i> chevron-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-left"><i class="fa fa-chevron-left"></i> chevron-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-right"><i class="fa fa-chevron-right"></i> chevron-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chevron-up"><i class="fa fa-chevron-up"></i> chevron-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;exchange"><i class="fa fa-exchange"></i> exchange</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-down"><i class="fa fa-hand-o-down"></i> hand-o-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-left"><i class="fa fa-hand-o-left"></i> hand-o-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-right"><i class="fa fa-hand-o-right"></i> hand-o-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hand-o-up"><i class="fa fa-hand-o-up"></i> hand-o-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;long-arrow-down"><i class="fa fa-long-arrow-down"></i> long-arrow-down</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;long-arrow-left"><i class="fa fa-long-arrow-left"></i> long-arrow-left</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;long-arrow-right"><i class="fa fa-long-arrow-right"></i> long-arrow-right</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;long-arrow-up"><i class="fa fa-long-arrow-up"></i> long-arrow-up</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-down"><i class="fa fa-toggle-down"></i> toggle-down <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-left"><i class="fa fa-toggle-left"></i> toggle-left <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-right"><i class="fa fa-toggle-right"></i> toggle-right <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;caret-square-o-up"><i class="fa fa-toggle-up"></i> toggle-up <span class="text-muted">(alias)</span></a></div>

                   </div>

               </section>
               <section id="video-player">
                   <h2 class="page-header">视频播放图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;arrows-alt"><i class="fa fa-arrows-alt"></i> arrows-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;backward"><i class="fa fa-backward"></i> backward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;compress"><i class="fa fa-compress"></i> compress</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;eject"><i class="fa fa-eject"></i> eject</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;expand"><i class="fa fa-expand"></i> expand</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fast-backward"><i class="fa fa-fast-backward"></i> fast-backward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fast-forward"><i class="fa fa-fast-forward"></i> fast-forward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;forward"><i class="fa fa-forward"></i> forward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pause"><i class="fa fa-pause"></i> pause</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;play"><i class="fa fa-play"></i> play</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;play-circle"><i class="fa fa-play-circle"></i> play-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;play-circle-o"><i class="fa fa-play-circle-o"></i> play-circle-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;random"><i class="fa fa-random"></i> random</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;step-backward"><i class="fa fa-step-backward"></i> step-backward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;step-forward"><i class="fa fa-step-forward"></i> step-forward</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stop"><i class="fa fa-stop"></i> stop</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;youtube-play"><i class="fa fa-youtube-play"></i> youtube-play</a></div>

                   </div>

               </section>
               <section id="brand">
                   <h2 class="page-header">品牌图标</h2>

                   <div class="row fontawesome-icon-list col-md-6 margin-bottom-lg">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;500px"><i class="fa fa-500px"></i> 500px</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;adn"><i class="fa fa-adn"></i> adn</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;amazon"><i class="fa fa-amazon"></i> amazon</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;android"><i class="fa fa-android"></i> android</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;angellist"><i class="fa fa-angellist"></i> angellist</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;apple"><i class="fa fa-apple"></i> apple</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;behance"><i class="fa fa-behance"></i> behance</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;behance-square"><i class="fa fa-behance-square"></i> behance-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bitbucket"><i class="fa fa-bitbucket"></i> bitbucket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;bitbucket-square"><i class="fa fa-bitbucket-square"></i> bitbucket-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;btc"><i class="fa fa-bitcoin"></i> bitcoin <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;black-tie"><i class="fa fa-black-tie"></i> black-tie</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;btc"><i class="fa fa-btc"></i> btc</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;buysellads"><i class="fa fa-buysellads"></i> buysellads</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-amex"><i class="fa fa-cc-amex"></i> cc-amex</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-diners-club"><i class="fa fa-cc-diners-club"></i> cc-diners-club</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-discover"><i class="fa fa-cc-discover"></i> cc-discover</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-jcb"><i class="fa fa-cc-jcb"></i> cc-jcb</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-mastercard"><i class="fa fa-cc-mastercard"></i> cc-mastercard</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-paypal"><i class="fa fa-cc-paypal"></i> cc-paypal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-stripe"><i class="fa fa-cc-stripe"></i> cc-stripe</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;cc-visa"><i class="fa fa-cc-visa"></i> cc-visa</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;chrome"><i class="fa fa-chrome"></i> chrome</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;codepen"><i class="fa fa-codepen"></i> codepen</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;connectdevelop"><i class="fa fa-connectdevelop"></i> connectdevelop</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;contao"><i class="fa fa-contao"></i> contao</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;css3"><i class="fa fa-css3"></i> css3</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;dashcube"><i class="fa fa-dashcube"></i> dashcube</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;delicious"><i class="fa fa-delicious"></i> delicious</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;deviantart"><i class="fa fa-deviantart"></i> deviantart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;digg"><i class="fa fa-digg"></i> digg</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;dribbble"><i class="fa fa-dribbble"></i> dribbble</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;dropbox"><i class="fa fa-dropbox"></i> dropbox</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;drupal"><i class="fa fa-drupal"></i> drupal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;empire"><i class="fa fa-empire"></i> empire</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;expeditedssl"><i class="fa fa-expeditedssl"></i> expeditedssl</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;facebook"><i class="fa fa-facebook"></i> facebook</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;facebook"><i class="fa fa-facebook-f"></i> facebook-f <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;facebook-official"><i class="fa fa-facebook-official"></i> facebook-official</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;facebook-square"><i class="fa fa-facebook-square"></i> facebook-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;firefox"><i class="fa fa-firefox"></i> firefox</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;flickr"><i class="fa fa-flickr"></i> flickr</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;fonticons"><i class="fa fa-fonticons"></i> fonticons</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;forumbee"><i class="fa fa-forumbee"></i> forumbee</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;foursquare"><i class="fa fa-foursquare"></i> foursquare</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;empire"><i class="fa fa-ge"></i> ge <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;get-pocket"><i class="fa fa-get-pocket"></i> get-pocket</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gg"><i class="fa fa-gg"></i> gg</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gg-circle"><i class="fa fa-gg-circle"></i> gg-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;git"><i class="fa fa-git"></i> git</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;git-square"><i class="fa fa-git-square"></i> git-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;github"><i class="fa fa-github"></i> github</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;github-alt"><i class="fa fa-github-alt"></i> github-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;github-square"><i class="fa fa-github-square"></i> github-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gratipay"><i class="fa fa-gittip"></i> gittip <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;google"><i class="fa fa-google"></i> google</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;google-plus"><i class="fa fa-google-plus"></i> google-plus</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;google-plus-square"><i class="fa fa-google-plus-square"></i> google-plus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;google-wallet"><i class="fa fa-google-wallet"></i> google-wallet</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;gratipay"><i class="fa fa-gratipay"></i> gratipay</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hacker-news"><i class="fa fa-hacker-news"></i> hacker-news</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;houzz"><i class="fa fa-houzz"></i> houzz</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;html5"><i class="fa fa-html5"></i> html5</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;instagram"><i class="fa fa-instagram"></i> instagram</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;internet-explorer"><i class="fa fa-internet-explorer"></i> internet-explorer</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ioxhost"><i class="fa fa-ioxhost"></i> ioxhost</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;joomla"><i class="fa fa-joomla"></i> joomla</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;jsfiddle"><i class="fa fa-jsfiddle"></i> jsfiddle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;lastfm"><i class="fa fa-lastfm"></i> lastfm</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;lastfm-square"><i class="fa fa-lastfm-square"></i> lastfm-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;leanpub"><i class="fa fa-leanpub"></i> leanpub</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;linkedin"><i class="fa fa-linkedin"></i> linkedin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;linkedin-square"><i class="fa fa-linkedin-square"></i> linkedin-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;linux"><i class="fa fa-linux"></i> linux</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;maxcdn"><i class="fa fa-maxcdn"></i> maxcdn</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;meanpath"><i class="fa fa-meanpath"></i> meanpath</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;medium"><i class="fa fa-medium"></i> medium</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;odnoklassniki"><i class="fa fa-odnoklassniki"></i> odnoklassniki</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;odnoklassniki-square"><i class="fa fa-odnoklassniki-square"></i> odnoklassniki-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;opencart"><i class="fa fa-opencart"></i> opencart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;openid"><i class="fa fa-openid"></i> openid</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;opera"><i class="fa fa-opera"></i> opera</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;optin-monster"><i class="fa fa-optin-monster"></i> optin-monster</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pagelines"><i class="fa fa-pagelines"></i> pagelines</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;paypal"><i class="fa fa-paypal"></i> paypal</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pied-piper"><i class="fa fa-pied-piper"></i> pied-piper</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pied-piper-alt"><i class="fa fa-pied-piper-alt"></i> pied-piper-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pinterest"><i class="fa fa-pinterest"></i> pinterest</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pinterest-p"><i class="fa fa-pinterest-p"></i> pinterest-p</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;pinterest-square"><i class="fa fa-pinterest-square"></i> pinterest-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;qq"><i class="fa fa-qq"></i> qq</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rebel"><i class="fa fa-ra"></i> ra <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;rebel"><i class="fa fa-rebel"></i> rebel</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reddit"><i class="fa fa-reddit"></i> reddit</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;reddit-square"><i class="fa fa-reddit-square"></i> reddit-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;renren"><i class="fa fa-renren"></i> renren</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;safari"><i class="fa fa-safari"></i> safari</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;sellsy"><i class="fa fa-sellsy"></i> sellsy</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-alt"><i class="fa fa-share-alt"></i> share-alt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;share-alt-square"><i class="fa fa-share-alt-square"></i> share-alt-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;shirtsinbulk"><i class="fa fa-shirtsinbulk"></i> shirtsinbulk</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;simplybuilt"><i class="fa fa-simplybuilt"></i> simplybuilt</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;skyatlas"><i class="fa fa-skyatlas"></i> skyatlas</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;skype"><i class="fa fa-skype"></i> skype</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;slack"><i class="fa fa-slack"></i> slack</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;slideshare"><i class="fa fa-slideshare"></i> slideshare</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;soundcloud"><i class="fa fa-soundcloud"></i> soundcloud</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;spotify"><i class="fa fa-spotify"></i> spotify</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stack-exchange"><i class="fa fa-stack-exchange"></i> stack-exchange</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stack-overflow"><i class="fa fa-stack-overflow"></i> stack-overflow</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;steam"><i class="fa fa-steam"></i> steam</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;steam-square"><i class="fa fa-steam-square"></i> steam-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stumbleupon"><i class="fa fa-stumbleupon"></i> stumbleupon</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stumbleupon-circle"><i class="fa fa-stumbleupon-circle"></i> stumbleupon-circle</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tencent-weibo"><i class="fa fa-tencent-weibo"></i> tencent-weibo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;trello"><i class="fa fa-trello"></i> trello</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tripadvisor"><i class="fa fa-tripadvisor"></i> tripadvisor</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tumblr"><i class="fa fa-tumblr"></i> tumblr</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;tumblr-square"><i class="fa fa-tumblr-square"></i> tumblr-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;twitch"><i class="fa fa-twitch"></i> twitch</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;twitter"><i class="fa fa-twitter"></i> twitter</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;twitter-square"><i class="fa fa-twitter-square"></i> twitter-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;viacoin"><i class="fa fa-viacoin"></i> viacoin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;vimeo"><i class="fa fa-vimeo"></i> vimeo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;vimeo-square"><i class="fa fa-vimeo-square"></i> vimeo-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;vine"><i class="fa fa-vine"></i> vine</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;vk"><i class="fa fa-vk"></i> vk</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;weixin"><i class="fa fa-wechat"></i> wechat <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;weibo"><i class="fa fa-weibo"></i> weibo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;weixin"><i class="fa fa-weixin"></i> weixin</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;whatsapp"><i class="fa fa-whatsapp"></i> whatsapp</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wikipedia-w"><i class="fa fa-wikipedia-w"></i> wikipedia-w</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;windows"><i class="fa fa-windows"></i> windows</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wordpress"><i class="fa fa-wordpress"></i> wordpress</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;xing"><i class="fa fa-xing"></i> xing</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;xing-square"><i class="fa fa-xing-square"></i> xing-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;y-combinator"><i class="fa fa-y-combinator"></i> y-combinator</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hacker-news"><i class="fa fa-y-combinator-square"></i> y-combinator-square <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;yahoo"><i class="fa fa-yahoo"></i> yahoo</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;y-combinator"><i class="fa fa-yc"></i> yc <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hacker-news"><i class="fa fa-yc-square"></i> yc-square <span class="text-muted">(alias)</span></a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;yelp"><i class="fa fa-yelp"></i> yelp</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;youtube"><i class="fa fa-youtube"></i> youtube</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;youtube-play"><i class="fa fa-youtube-play"></i> youtube-play</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;youtube-square"><i class="fa fa-youtube-square"></i> youtube-square</a></div>

                   </div>

               </section>
               <section id="medical">
                   <h2 class="page-header">医疗图标</h2>

                   <div class="row fontawesome-icon-list col-md-6">



                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;ambulance"><i class="fa fa-ambulance"></i> ambulance</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;h-square"><i class="fa fa-h-square"></i> h-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heart"><i class="fa fa-heart"></i> heart</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heart-o"><i class="fa fa-heart-o"></i> heart-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;heartbeat"><i class="fa fa-heartbeat"></i> heartbeat</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;hospital-o"><i class="fa fa-hospital-o"></i> hospital-o</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;medkit"><i class="fa fa-medkit"></i> medkit</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;plus-square"><i class="fa fa-plus-square"></i> plus-square</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;stethoscope"><i class="fa fa-stethoscope"></i> stethoscope</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;user-md"><i class="fa fa-user-md"></i> user-md</a></div>

                       <div class="fa-hover col-md-6 col-sm-4"><a href="javascript:;wheelchair"><i class="fa fa-wheelchair"></i> wheelchair</a></div>

                   </div>

               </section>
</body>

</html>
