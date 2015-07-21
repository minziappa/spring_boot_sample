<#import "layout/defaultLayout.ftl" as layout>
<#import "/spring.ftl" as spring/>
<@layout.myLayout>


  <div><h1>Testaaaa</h1></div>
  
  a-<@spring.message "sample.parameter.error.message"/>-b

</@layout.myLayout>