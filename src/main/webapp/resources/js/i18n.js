/**
 * Created by Sooyoung on 2016-09-23.
 * ajax 호출
 */
function loadBundle(key) {
	var lang = $('#locale').val();
	var returnValue;
	jQuery.i18n.properties({
		name:'messages',
		path:'/locale/',
		mode:'map',
		language:lang,
		callback: function() {
			returnValue=jQuery.i18n.prop(key);
		}
	});
	return returnValue;
}