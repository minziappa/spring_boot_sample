<#macro myLayout title="FreeMarker example">
  <html>
    <head>
      <title>
        ${title}
      </title>
    </head>
    <body style="width:100%;height:100%">
      <table border="1" cellspacing="0" cellpadding="0" style="width:100%;height:100%">
        <tr height="10%">
          <td colspan="2">
            <#include "header.ftl"/>
          </td>
        </tr>
        <tr>
          <td width="10%">
            <#include "menu.ftl"/>
          </td>
          <td>
            <#nested/>
          </td>
        </tr>
        <tr height="10%">
          <td colspan="2">
            <#include "footer.ftl"/>
          </td>
        </tr>
      </table>
    </body>
  </html>
</#macro>