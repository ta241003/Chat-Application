select * from serverName

go
create proc ST_servername (@servername nvarchar(50),@ip nvarchar(50),@port nvarchar(50))
as
begin
insert into serverName values
(@servername,@ip,@port)
end


EXEC ST_SERVERNAME 'AAA','192.11','1221'


delete serverName


