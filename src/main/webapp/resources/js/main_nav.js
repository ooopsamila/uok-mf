function injectFacebox(){

    var fbcodeBulkNormal= "\
<div class='boxes'><div id='sccfBulkNormal' class='window'> \
<table width='100%' border='0' cellspacing='0' cellpadding='0' class='faceboxtable'>\
   <tr>\
    <td class='mcontent'>Please Select a Campaign Type</td>\
  </tr>\
  <tr>\
    <td class='mbutton'><table width='100%' border='0' cellspacing='0' cellpadding='0'>\
        <tr>\
        <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_NORMAL'>\
          <td width='30%' align='center'> <div class='span2'><a href='/campaign-management/createCampaign/main.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/reward.png' title='Normal flow'/></div>\
		  <div class='flow-dialog-label'>Normal Flow</div></a></td>\
          <td width='3%'>&nbsp;</td>\
          </sec:authorize>\
          <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_BULK_REWARDS'>\
          <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/bulkRewards/createBulkMain.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/bulk-reward.png' title='Bulk Rewards'/></div>\
		  <div class='flow-dialog-label'>Bulk Rewards</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  \
        </tr>\
      </table></td>\
  </tr>\
  \
</table>\
\
</div></div>";

    $('#sccfBulkNormal').remove();
    $(fbcodeBulkNormal).insertBefore('#mask');
    $('body').append($('#sccfBulkNormal').parent());

    var fbcodeNormalInsta= "\
<div class='boxes'><div id='sccfNormalInsta' class='window'> \
<table width='100%' border='0' cellspacing='0' cellpadding='0' class='faceboxtable'>\
   <tr>\
    <td class='mcontent'>Please Select a Campaign Type</td>\
  </tr>\
  <tr>\
    <td class='mbutton'><table width='100%' border='0' cellspacing='0' cellpadding='0'>\
        <tr>\
        <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_NORMAL'>\
          <td width='30%' align='center'> <div class='span2'><a href='/campaign-management/createCampaign/main.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/reward.png' title='Normal flow'/></div>\
		  <div class='flow-dialog-label'>Normal Flow</div></a></td>\
          <td width='3%'>&nbsp;</td>\
          </sec:authorize>\
		  <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_INSTANT_REWARDS'>\
		  <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/createInstantCampaign/primary.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/instant-reward.png' title='Instant Campaign'/></div>\
		  <div class='flow-dialog-label'>Instant Campaign</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  \
        </tr>\
      </table></td>\
  </tr>\
  \
</table>\
\
</div></div>";

    $('#sccfNormalInsta').remove();
    $(fbcodeNormalInsta).insertBefore('#mask');
    $('body').append($('#sccfNormalInsta').parent());

    var fbcodeBulkInsta= "\
<div class='boxes'><div id='sccfBulkInsta' class='window'> \
<table width='100%' border='0' cellspacing='0' cellpadding='0' class='faceboxtable'>\
   <tr>\
    <td class='mcontent'>Please Select a Campaign Type</td>\
  </tr>\
  <tr>\
    <td class='mbutton'><table width='100%' border='0' cellspacing='0' cellpadding='0'>\
        <tr>\
          <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_BULK_REWARDS'>\
          <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/bulkRewards/createBulkMain.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/bulk-reward.png' title='Bulk Rewards'/></div>\
		  <div class='flow-dialog-label'>Bulk Rewards</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_INSTANT_REWARDS'>\
		  <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/createInstantCampaign/primary.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/instant-reward.png' title='Instant Campaign'/></div>\
		  <div class='flow-dialog-label'>Instant Campaign</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  \
        </tr>\
      </table></td>\
  </tr>\
  \
</table>\
\
</div></div>";

    $('#sccfBulkInsta').remove();
    $(fbcodeBulkInsta).insertBefore('#mask');
    $('body').append($('#sccfBulkInsta').parent());

    var fbcodeAll= "\
<div class='boxes'><div id='sccfAll' class='window'> \
<table width='100%' border='0' cellspacing='0' cellpadding='0' class='faceboxtable'>\
   <tr>\
    <td class='mcontent'>Please Select a Campaign Type</td>\
  </tr>\
  <tr>\
    <td class='mbutton'><table width='100%' border='0' cellspacing='0' cellpadding='0'>\
        <tr>\
        <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_NORMAL'>\
          <td width='30%' align='center'> <div class='span2'><a href='/campaign-management/createCampaign/main.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/reward.png' title='Normal flow'/></div>\
		  <div class='flow-dialog-label'>Normal Flow</div></a></td>\
          <td width='3%'>&nbsp;</td>\
          </sec:authorize>\
          <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_BULK_REWARDS'>\
          <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/bulkRewards/createBulkMain.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/bulk-reward.png' title='Bulk Rewards'/></div>\
		  <div class='flow-dialog-label'>Bulk Rewards</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  <sec:authorize ifAnyGranted='ROLE_CAMPAIGN_CREATION_INSTANT_REWARDS'>\
		  <td width='30%' align='center'><div class='span2'> <a href='/campaign-management/createInstantCampaign/primary.html' style='cursor:pointer'><img src='/campaign-management/themes/"+theme+"/images/instant-reward.png' title='Instant Campaign'/></div>\
		  <div class='flow-dialog-label'>Instant Campaign</div></a></td>\
		  <td width='3%'>&nbsp;</td>\
		  </sec:authorize>\
		  \
        </tr>\
      </table></td>\
  </tr>\
  \
</table>\
\
</div></div>";

    $('#sccfAll').remove();
    $(fbcodeAll).insertBefore('#mask');
    $('body').append($('#sccfAll').parent());

}





