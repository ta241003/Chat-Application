USE [ChatApplication]
GO
/****** Object:  StoredProcedure [dbo].[ST_servername]    Script Date: 6/18/2022 2:29:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER proc [dbo].[ST_servername] (@servername nvarchar(50),@ip nvarchar(50),@port nvarchar(50))
as
begin
insert into serverName values
(@servername,@ip,@port)
end