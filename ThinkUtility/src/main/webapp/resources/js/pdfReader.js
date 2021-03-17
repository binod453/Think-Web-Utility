//var divHeight = $( window ).height() - ($("header nav").innerHeight() + +$("#headingDiv").height() + $("footer").height() + 16);	
//$("#previewbox").css({'height':divHeight});	


 var url = document.getElementById('pdfURL').value;
console.log('url', url);	 
 //  PDFJS.GlobalWorkerOptions.workerSrc = 'http://localhost:8280/pdfviewer/build/pdf.worker.js';
  PDFJS.disableWorker = true;
  
  var pdfDoc = null,
      pageNum = 1,
      pageRendering = false,
      pageNumPending = null,
      scale = 1.5,
      canvas = document.getElementById('the-canvas'),
      ctx = canvas.getContext('2d');
   //  copyAllowed = $("#copyAllowed").val();
  /**
	 * Get page info from document, resize canvas accordingly, and
	 * render page.
	 * 
	 * @param num
	 *            Page number.
	 */
  function renderPage(num) {
    pageRendering = true;
    // Using promise to fetch the page
    pdfDoc.getPage(num).then(function(page) {
      var viewport = page.getViewport(scale);
      canvas.height = viewport.height;
      canvas.width = viewport.width;

      // Render PDF page into canvas context
      var renderContext = {
        canvasContext: ctx,
        viewport: viewport
      };
      
  	/*if('true' == copyAllowed){
  		page.render(renderContext).then(function() {
  		    // Returns a promise, on resolving it will return text contents of the page
  		    return page.getTextContent();
  		}).then(function(textContent) {
  		     // PDF canvas
  		    var pdf_canvas = $("#the-canvas"); 

  		    // Canvas offset
  		    var canvas_offset = pdf_canvas.offset();
  		  $("#text-layer").html('');
  		    // Canvas height
  		    var canvas_height = pdf_canvas.get(0).height;

  		    // Canvas width
  		    var canvas_width = pdf_canvas.get(0).width;

  		    // Assign CSS to the text-layer element
  		    $("#text-layer").css({ left: canvas_offset.left + 'px', top: canvas_offset.top + 'px', height: canvas_height + 'px', width: canvas_width + 'px' });

  		    // Pass the data to the method for rendering of text over the pdf canvas.
  		    PDFJS.renderTextLayer({
  		        textContent: textContent,
  		        container: $("#text-layer").get(0),
  		        viewport: viewport,
  		        textDivs: []
  		    });
  		 
  		
  	          pageRendering = false;
  	          if (pageNumPending !== null) {
  	            // New page rendering is pending
  	            renderPage(pageNumPending);
  	            pageNumPending = null;
  	          }
  	        
  		});
  	}
  	else
  		{*/
      var renderTask = page.render(renderContext);
      renderTask.promise.then(function () {
          pageRendering = false;
          if (pageNumPending !== null) {
            // New page rendering is pending
            renderPage(pageNumPending);
            pageNumPending = null;
          }
        });
  	//	}
      // Wait for rendering to finish
  	$("#page-loader").hide();
    });

    // Update page counters
    document.getElementById('page_num').textContent = num;
  }

  function queueRenderPage(num) {
    if (pageRendering) {
      pageNumPending = num;
    } else {
      renderPage(num);
    }
  }

  function onPrevPage() {
    if (pageNum <= 1) {
      return;
    }
    pageNum--;
    queueRenderPage(pageNum);
  }
  document.getElementById('prev').addEventListener('click', onPrevPage);

  function onNextPage() {
    if (pageNum >= pdfDoc.numPages) {
      return;
    }
    pageNum++;
    queueRenderPage(pageNum);
  }
  document.getElementById('next').addEventListener('click', onNextPage);

  PDFJS.getDocument(url).then(function (pdfDoc_) {
    pdfDoc = pdfDoc_;
    document.getElementById('page_count').textContent = pdfDoc.numPages;

    // Initial/first page rendering
    renderPage(pageNum);
  });
		
  $( document ).ready(function() {
		var accessToArticle = $("#emailAllowed").val();
		
		
			var pdfExist = $("#downloadAllowed").val();
			if('true' == pdfExist){
				
				$.urlParam = function(name){
				    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
				    if (results==null){
				       return null;
				    }
				    else{
				       return decodeURI(results[1]) || 0;
				    }
				}
				//var urlParams = new URLSearchParams(window.location.search);
				$("#pdfLink").attr("title","PDF").attr("target","_blank").attr("href","downloadArticlePDF?articleId="+ $.urlParam('articleId'));
			}else{
				$("#pdfLink").attr("title","PDF not available").removeAttr("href");
			}
		
		
		if(accessToArticle == "true"){
			
			$("#emailShareLink").attr("href", "mailto:?subject=Check this article out&body=Please visit " +window.location);
		}else{
			
			$("#emailShareLink").removeAttr("href");
			$("#shareLinks").removeAttr("href");
			
			 $('.share-container').addClass('hideDiv');
		}
	});
  
	if('true' != $("#copyAllowed").val()){
  $(document).bind("contextmenu", function (e) {
      e.preventDefault();
      return false;
  });
  
 
  
	}
