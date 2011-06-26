$(document)
		.ready(
				function() {
					// check name availability on focus lost
					var offSet = 80;
					var headerHeightFromTop = $('#header').height();
					var sidePanelHeightFromTop = $('#sidepanel').height()
							+ headerHeightFromTop;
					var contentHeightFromTop = $("#content").height()
							+ headerHeightFromTop;

					if (sidePanelHeightFromTop > contentHeightFromTop) {
						var carPoolFrameHeight = offSet
								+ sidePanelHeightFromTop + 'px';
					} else {
						var carPoolFrameHeight = offSet + contentHeightFromTop
								+ 'px';
					}

					document.getElementById('carpool_frame').style.paddingTop = carPoolFrameHeight;

				});
