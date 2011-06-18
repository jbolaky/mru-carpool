var offSet = 80;
var headerHeightFromTop = document.getElementById('header').offsetHeight;
var sidePanelHeightFromTop = document.getElementById('sidepanel').offsetHeight + headerHeightFromTop; 
var contentHeightFromTop = document.getElementById('content').offsetHeight + headerHeightFromTop; 

if(sidePanelHeightFromTop>contentHeightFromTop){
	var carPoolFrameHeight = offSet + sidePanelHeightFromTop + 'px';
} else {
	var carPoolFrameHeight = offSet + contentHeightFromTop + 'px';
}

document.getElementById('carpool_frame').style.paddingTop = carPoolFrameHeight;
