## Create a bucket
```
aws s3 mb s3://my-prefixes-bucket-msr-671
```

## Create a Folder
```
aws s3api put-object --bucket="my-prefixes-bucket-msr-671" --key="images/"
```

## Create Many Folders along with a file
```
aws s3api put-object --bucket="my-prefixes-bucket-msr-671" --key="folder000/folder001/folder002/folder003/folder004/folder005/folder006/folder007/folder008/folder009/folder010/folder011/folder012/folder013/folder014/folder015/folder016/folder017/folder018/folder019/folder020/folder021/folder022/folder023/folder024/folder025/folder026/folder027/folder028/folder029/folder030/folder031/folder032/folder033/folder034/folder035/folder036/folder037/folder038/folder039/folder040/folder041/folder042/folder043/folder044/folder045/folder046/folder047/folder048/folder049/folder050/folder051/folder052/folder053/folder054/folder055/folder056/folder057/folder058/folder059/folder060/folder061/folder062/folder063/folder064/folder065/folder066/folder067/folder068/folder069/folder070/folder071/folder072/folder073/folder074/folder075/folder076/folder077/folder078/folder079/folder080/folder081/folder082/folder083/folder084/folder085/folder086/folder087/folder088/folder089/folder090/folder091/folder092/folder093/folder094/folder095/folder096/folder097/folder098/folder099/Welcome1000.txt" --body="welcome.txt"
```

## Check if object is present
```
aws s3api head-object --bucket my-prefixes-bucket-msr-671 --key folder000/folder001/folder002/folder003/folder004/folder005/folder006/folder007/folder008/folder009/folder010/folder011/folder012/folder013/folder014/folder015/folder016/folder017/folder018/folder019/folder020/folder021/folder022/folder023/folder024/folder025/folder026/folder027/folder028/folder029/folder030/folder031/folder032/folder033/folder034/folder035/folder036/folder037/folder038/folder039/folder040/folder041/folder042/folder043/folder044/folder045/folder046/folder047/folder048/folder049/folder050/folder051/folder052/folder053/folder054/folder055/folder056/folder057/folder058/folder059/folder060/folder061/folder062/folder063/folder064/folder065/folder066/folder067/folder068/folder069/folder070/folder071/folder072/folder073/folder074/folder075/folder076/folder077/folder078/folder079/folder080/folder081/folder082/folder083/folder084/folder085/folder086/folder087/folder088/folder089/folder090/folder091/folder092/folder093/folder094/folder095/folder096/folder097/folder098/folder099/Welcome1000.txt
```

## Create Only Folders
```
aws s3api put-object --bucket="my-prefixes-bucket-msr-671" --key="folder000/folder001/folder002/folder003/folder004/folder005/folder006/folder007/folder008/folder009/folder010/folder011/folder012/folder013/folder014/folder015/folder016/folder017/folder018/folder019/folder020/folder021/folder022/folder023/folder024/folder025/folder026/folder027/folder028/folder029/folder030/folder031/folder032/folder033/folder034/folder035/folder036/folder037/folder038/folder039/folder040/folder041/folder042/folder043/folder044/folder045/folder046/folder047/folder048/folder049/folder050/folder051/folder052/folder053/folder054/folder055/folder056/folder057/folder058/folder059/folder060/folder061/folder062/folder063/folder064/folder065/folder066/folder067/folder068/folder069/folder070/folder071/folder072/folder073/folder074/folder075/folder076/folder077/folder078/folder079/folder080/folder081/folder082/folder083/folder084/folder085/folder086/folder087/folder088/folder089/folder090/folder091/folder092/folder093/folder094/folder095/folder096/folder097/folder098/folder099/folder100/final"
```

## Trying to create beyond 1024
```
aws s3api put-object --bucket="my-prefixes-bucket-msr-671" --key="folder000/folder001/folder002/folder003/folder004/folder005/folder006/folder007/folder008/folder009/folder010/folder011/folder012/folder013/folder014/folder015/folder016/folder017/folder018/folder019/folder020/folder021/folder022/folder023/folder024/folder025/folder026/folder027/folder028/folder029/folder030/folder031/folder032/folder033/folder034/folder035/folder036/folder037/folder038/folder039/folder040/folder041/folder042/folder043/folder044/folder045/folder046/folder047/folder048/folder049/folder050/folder051/folder052/folder053/folder054/folder055/folder056/folder057/folder058/folder059/folder060/folder061/folder062/folder063/folder064/folder065/folder066/folder067/folder068/folder069/folder070/folder071/folder072/folder073/folder074/folder075/folder076/folder077/folder078/folder079/folder080/folder081/folder082/folder083/folder084/folder085/folder086/folder087/folder088/folder089/folder090/folder091/folder092/folder093/folder094/folder095/folder096/folder097/folder098/folder099/folder100/final/onelastfolder"
```
### output
```
An error occurred (KeyTooLongError) when calling the PutObject operation: Your key is too long
```

## Trying to create nested folder
```
aws s3api put-object --bucket="my-prefixes-bucket-msr-671" --key="folder000/folder001/images/"
```

## Finally Checking the S3 Objects created
```
aws s3api list-objects --bucket my-prefixes-bucket-msr-671 > list-object-response.txt
```