<#import "layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>


  <div><h1>This is a test</h1></div>
  
  a-<@spring.message "sample.parameter.error.message"/>-b
					<form action="/uploadFiles" enctype="multipart/form-data" method="POST">
          <b style="color:red" >${errorMessage?if_exists}</b>
						<table style="border-collapse: collapse;">
							<tr>
								<td style="padding: 3px;">Image File</td>
								<td style="padding: 3px;"><input type="file" name="file"/></td>
								<td style="padding: 3px;">Example)file.csv</td>
							</tr>
							<tr>
								<td style="padding: 3px;"><input class="btn btn-sm btn-primary" type="submit" value="Register" /></td>
								<td style="padding: 3px;"></td>
								<td style="padding: 3px;"></td>
							</tr>
						</table>
					</form>
</@layout.myLayout>