var subMenuContents = $('div.sub-menu');
for(i = 0; i < subMenuContents.length; ++i){
    var src = subMenuContents.eq(i).data('content-source');
    subMenuContents.eq(i).load(src);
}