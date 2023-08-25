<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상세 게시글임
${currentUser.name }<br>
	<!-- 1. 만약 currentUser있나? -->
	<!-- 2. ${currentuser.name}님 안녕하세요 -->
	<!-- 3. 로그아웃 링크 생성, 로그인 링크 지우고 -->
	<a href="${pageContext.request.contextPath }/">
		<img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBYWFRgVFhUZGBgYGBgYGBgYGBoYGBgaGBgZGhgYGhgcIS4lHB4rHxgYJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHxISHjUrJSQ0NDY0NDQxNDQ0NDQxNDQ0MTQ0NDQ0NDQ0NDQ0NDE0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIAOEA4QMBIgACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAAEAAECAwUGB//EAEEQAAIBAgQDBQQIBAUDBQAAAAECAAMRBBIhMQVBUSJhcYGRBjKhsRMUQlJywdHhYoKS8CMkM6KyFRZTBzRzk/H/xAAaAQACAwEBAAAAAAAAAAAAAAAAAgEDBQQG/8QALREAAgIBBAECBgIBBQAAAAAAAAECEQMEEiExQRNRBSIyYXGBM5FSFEPR4fD/2gAMAwEAAhEDEQA/AOdiiinoTy4ooooEDiNJRQAUUUcQAa0Vo8eADWitHEVuchtLslJvoQEdVubSH1hB9q/hqfhK6OOQnZrDuHyvKZajHHtnRDSZZcpF9ogJW9e6MyqSRsDYZj07oRS7ShhfUaC1zcbiw6flF/1eL/Id6HOvBC0a0h9aTWxJt3HS97b+Bl1tAessjmhLiLspnp8kFclRC0QWSivLSkjaPlj3igA4WPaK8e8AFljsI145kEjZYrRyYhJIGtFHigFgkUUUAHEeOIxgAooohABR4hGgA8cCV1Klh1PIDcwKv9MwuVsnQX1HeeYnLn1UcXD7OzTaKebnpF9THILgMCdtdu/XnB8737T3uLjbKy3ty2F+Y25zR4NgD7ygHSxUi/cbNbblrt6TYTgYK3UDUl0BFsrqLshPRlDA+Ex82pllfLN7DpIYV1+zBThtxquU2vcAAEX0ICjUg7jptCsPw1s40Fmstr6K5IsQfutdbH+ITfwNhlTyUk6q66lGPUqWHih7oS1kbNlBSolj95DYgWPdqPIdJzcs6eF0irDcJGQAr797X1sxBBFv75dIJU4cUZxyXPr+JbH4s3oJpYPHMLq1jZ0N9tWK5vC7Bm/mllSv27N7pY5r8wBnB7ukEgtnMUsBqxsQpTObDYZ7W7zlGl4sVTYdvYMA9htZQAb9+oufGdCKlNFdCQACAxvyZiTa+9laFYrBI9NVUgXBNt7hRqum2uX4RlKUHcWK1GaqSOPAJ3Fj05XtewPhI2m7jOHhFF+1ZiS2/ZpUVDsR0zkj+ac/hqlyVblcj8wf5jbymppdc5PbP+zJ1nw+Nb8f9EyI8RMU1TEY5jR7xXgA4EeNeKACMRivHgKNFJad8UCaA7RxCHwFVVztTdV+8VIHrBxFTT6Gaa7HERjiPGIIyMmYoAISJ/v9I8EqI7uAvurY77nn5iUajN6UL8nVpMHrTrx5L8BhWqOCQRa1geQIGu3ynZ4fhHYAuNugIv3iC8MpBSDpe3hcnUzpqdrbTz8pPI7kemjBY4qMTCwXDcjkp2eqn3b9AT3fITaTC3BG3MfwncS1AISlrSIxQSkznsZw052IFg4F+gdbW+Q17pYcMxADDe4YctbX08gfKb7UwYzUr/CNtF3s5p8ESoOt+zf+U/tI1x2Ea1w5YH42+DCdMuGFrQJsF2AoG3zg4kqVnKHC5jmbqxbvBKj5KPWQGMKuq31DKp7wgzPbpmcj+mdB9QsqjoRfwve0yqnCO3n8T66/rFcRk0DPUd0yXv2VUDm7sTUa4HLM6MR0p2mfxXArTyqBc2UEg6sxN+mvaKL+83Fwzrcg6hTbTYsSxI7xc2lTYN6rFxawACX5sDcEju94+HfFfBNWYYXTXf53Jt8j6SEN4zg3QAg2uyanSwAC695yqbeMBeqpd0G62zdNRuJsaLVbltl34MP4ho9r9SC48jiKKSmkZFDR4geUlIsmiIiMeIQsGmKKPljwsXazpqHGUxNWnRyNZqyMVexUqtOxUjn2heXfR4bE1a2GFBaTpnyVE0vkNtQB1O0owB4fRqCoMQ7vmupymyE3vcAba21lq8TweGNWtSdq1apntoQAWN7bWAv56Tha5+VP/s1E/wDJrvn8AHtbhMhpKiWVKKlyq6Ak7sR4c5z+Hw7ObIjOQNlUt8p2r+1WHqZqT5lptSVS6r2s3MWsdP3ksHxjA03dxUcs9ixyMq9nYAKBrHjOcY007Kp44SlafBi+x+GDYhs6XyU3bKw2YWGx56mZ1PhzsXzXp5ULnOrddBtpf8p1lDi+CWs9Zajq9QG5KHKosBa1t7gG8qxvtBQek9AO7Xp5RVdSS7Xub2EN891pd0T6ePbTa4s4DGVsiM3QfE6CS9n8NexG51Jvpr85VxKgXyINAz3J7lH7zouD4VUAA5Dfn+04tfPdLb7Gl8Nx7Ybvc2+H0BYX+fymwi6QLDUtpoUxOBI0pMemNZcokFSEIkZIRsiFlyrJIstVY6RW2VWiyy7LIsJIWCNTG0peiIaUvKai2kMZIDqYcayinhQDtpv/AH6CEVDK1qdYjafY9NAHEcCHAvrrcXG7cz8fK84rjdJabFghDK1zb7YN7g+pM7962vgNL7WmXxHALWU3sd7jp32hB7ZXEiUd0XGXTOQDAi42IvfuIvPQeKYfD1SmHYBKhpq9NwAAxI1RreE4TIULIQLppcc1OxHduPKEY7iL1mVnIuihVsLaLt5zbV5VGSZ5uVYJSi1f/BucVwJpYJFZQHWuyk21I7VteY2lfHUQUsGcosaV2sLFtVvfv3mfjuN1ayJTqMGVDcG3aJAI1PPQynEcSd1po1rUlyppy0367CNGE+L92Q8kHdeyO4biFE2+irYZEsLI9K7DTn2h8pz3tZTbNSdjTdGXstSXKGAIJuLnrveQX2uxG1qf9A/WZ/E+LVMQVLsOzooAAA8pXDDOMrHyZoSjSOo/6lw7/wAY/wDrimH/ANz1/wCD+gRR/Sl/5lfqROXvHBkYhOopLBJSsGSvAUnePeQBiZraxZOlZMVbSJYYXcm2wC/G5nUcNTbpOZ4SpOvX8zOuwQ7Nuk8/mk5TbZ6vTwUcaSNSj+ULQnygmHhgMqRYy1TLllKS5BLEVstSSzRgsYiSQW5pEtIxPAihEyqpGkXaQxkgeqsFqQqoYM4vKmWxAKt9Y1OpYH4y50g7kAEdQR+n998iPY7qjkuIVh9Myj7QJv4a2+fpKSYPiQDiQSLEK3yI/OECbmhv0zzfxNL1v0K8UV4p2mYPEYooAPeKK8UKJARHEiY4MC0mDHkRHECCai5t/ZmriOAVRSL6E29wXLawThVPNVQDr8gTOtwGOc2Soo7WzLp4Aj85na3UODUY+TX+HaSOWLyS8M53CYcoFXw+U6LADTxkeI4YK1xzGn5wjApMpmvHoJUW3hmHkBS5xVaoQX+A1+EZKhXK+A5bWkhWUbznBx9dewwA5sUT4M15L/qtJtjrzyMrt/SjE/CSmK4vydIldTsRLbTl8Ljkc9hwSu4v2h4qdR5zew+IuLb98FKyHFoJyxssWaOHkgVlJU6S8vKHqja4itEpsGdZQ0NZIBiLiK0PGRQ4mXj61tvA+cPqVNJj8QbSKuyyuDC4lTH0yuPuNttuB+cql1SrmB7rW/v+9pTN3RKsZ5n4i7zfoV48jHnWZ48aKKADxRooABxRzIwLyQMkDIRxAho1vZ0j6wgPPOo8SjATtMNhVKBjeyqo03uo1+Ok4Dh7EVaZG4dLf1DSenVhcKim2l2PzmRr4/On9jc+GSfpOP3OfxWI+kVHAIBJGu4I0ImjgUtaNxaiFSmBsD8wT85Ph4vOCnZo2q4NRFvK6+ERgbi8ITaNeMVcro5t+AIM5CgllZQSASpIIBBtpa/Kck/s6y2RqYtawK0VZ2a51FYbb92gG2t/T2ToZQ+FJ1NvHUSVwgfPZyPFOBsiU2zlnRFu4N3VgBftbsp6G/ptp8JxDlRm3Fr9CDswmq3DhfMTttYsLehklphVygAevzMVrmy1SW3b2E0mJEjWxQXc2ltFtJz/ABUZ3IvsLgdTyg3SIjG3yWY/jyKDmcKOpIA9ZkLxum5ur379cvrtBOH8AWpVvWYZhewIOa+ltWFgL3200mS1bEpZVqVFYXDsaihUIJ7P0WTUbDeCTfZLcY8Hc8PxTMLq4YdzZhDXe+84T6WoESpWAR3F0qUxla/LOuxBFuo7p0/CsW7oC9i1tSux77codcMKtbkV4lrNvMXH1NL+Pxmrjh2rznuNVLC0iuRt3y2AUzoT1PykpCmLADoPjzkxPQYI7YJHk9TPdkbFFeIxS8oHvFGjwFFFFFAAUxpMyJkFxGPeNFAkJwVQrUpsNw6n4ien4MB85Is2n9ieUgz0/guJV6KODqyi/jsR6iZuvj1I1fh06TiVcSBCKGNyrAH42+EnwvaV8WBC9xII8jrFw9rTNNTwbdOXZO6U0IUIwrZS1ORyy9iIPUxAGsAXJB1gztrbnIVsQz7aCWUqB57xOyxKuwhDZZz1btOTN90IWc/XGR9dAechjw5NOigYd8qxHCUY5mRC3JigJ028dpfhhpeGkRosrmmmYXEOHCoe1rYdNvCLCYEIOyTbpNWoJWFkNckpuqMfHJznO1cKar5eXOdHxWpaYT4Zylw1ka+Yg2Ol9D3RW65HjG6TKOKIgXslSyEK1jffrbfaZd4VjECpTQDUrnfxYnL6Lb1gk3NFu9FbjzvxLZ67UfA4Me8jFOsziQMV4ooAKKRikgVyJMkZCQWIYxR4iO+QyUOhF9duc6LgnEzQBBBZCcygmxB/Sc/SsNSPP9oQAx1tfoQNvCZ+sk6pI09DBXus6YcZbEMwIsotlHPfUkzYwy2tOQ4DSIqMTfUDfxM7TDLoJmK75NZtVwaWHvcG+ltoWXgeHl1QHYbwFI1K19BKMTRJQ23IhCoB4xrwoZOjHq8Wo017bBSNLWJa45WGsK4VxRHGZWup8QR3EHUR8Tw6m5u6Kx6kA+kGr8Nt7lhyI2vI5Q/yyNetWW0weIKH21tBcemICEDs9D7/AMIBwbiLqGSs2dvsj6Nla/MaCxEiTseMWlaOp4Xc0x1GnpDQIFwpcqi/M3t0vNGNFFcnyUut4NU0hVRrTOxdXeDBMxeJHO4Qczr3DmfSWvSU0LEhVzanooJLeeW8oo0nqMzKQLm1zyUbgeJmdxzEBKX0Ya7M2ttgOcbHBymo+5GTIoQcvYxsbifpKjPyJ0HRRoB6CUgysGSvN+EVGKS8HlsknOTk/JO8V5GPHK6JXivIxQIoneNGigFFZkZ13CvYw1qKVvpsudc2XJe3dfNMfgXBvrNc0c+TKrHNlvfKQNr98qWWLvno6PRkq47MmNOqxvsjkr06P0tw6uxbJ7uS3K/O4l3/AGWL/wCubc+xr5dqR60X5JeJrhnHTbwWGJQsysoA957i/goFzOswfBKNIdhbv99tX8uS+UJOCBWza+MqyOM1Q2OUoS+U5bgadonqSBp0nV4XaY9GmA5y6AEgeU18OZkTVSdG/CTcFYdSOsPPxtMwvaGU6lxAGYeP9oDTYq9FwAdGAzK3fZdR5iNhePo+q2PntNbH0FdDfpv075yOIwChgHVSDsbDXz6yqTaOrDGElT7Oop8RW9msO/vl4IJBBBnHvwRwc1Kocu4DEsB3eHnIF8SnvJcD7SHfyP6yFN+S96WL+lnY1d7SgUh0nOJx5ObFW/iBA+MOocdQmzEDv5GSpJlM8Mo9G9QtLy0CwdUNexvLmf5R0cz7KsS0wOJ4m/ZB942mhi6285/G4apVzCn7ygEXtY67a89D6R4xcnQspqMdz8GjQGS6k77HxnG8VxAeobbLoO/qfWdNj+HYp0VVZCSAHtdSLjYMSQR8ZyeMwT0myOuU8uYI6gjQzQ0uDa90nyZ2s1KnFRj15KhLFlIM672IwaD6TFVfcojs32zWuT5C1vGds57I2ZsYbnRPhXsTWqKGqMKSnYEXe3eNh6w+p7FUNhirN0OT5XnP8d9pquIYgMyU/soptp1Yjc90xJUo5Jct0WN4o8JX9za417O1sN2ms6cnTUeY+zMea+B4nXw9ldXak4s1OoDkdTvlzbHwgOMw5Ul1RxTY9hnUi4OoF9j+0thKXUv7K5xj2v6BYorRSzgqPRcBxdaSJh6d3CDLewuZPC4JKZ+kpoqO2hbUmzEEixNtYsNhhSSwGvM8zLa79lbb509MwvOSUY9RRZHLNfUwqtU7YB55vgIiZXXPbTxI9VP6SxhK64RZubbGRbmRxLWBPSWLtMrjWJsUpjdySfwoBf8A3Mg84snSbLMcd0kvcFpLpfzh1GptKqCaeUpdsjW9Jndm7VGo7XEuw730gKVbiX4Z9RIaA0qaAC3966yGKwauLECTVpcDCiLado5ythHpmym45SC44jRh4zo2WUVcOh3AMVx9jpjqHXKOL4o6NeyC57pj0+Dmo2iHx1HynoD8PQbKPSRNMLtFUCyWqtUkPwTAJQp5B4k76mSxFS15H6Ww3geIq3MdI5G7dg9dt4/ChZSfvH4DQfnB655DnpD6CWsvQTr08LdnFrMu2Kj7hTVQisx053PIDnOL41jWq51ZcoAzpcWOnO/eAROkcfSVMh9xLFu/7q/n6TF9ugAaRGhIdT4AqR8zNCCUXXlmQ5OfXSOUWdDSxduHMgOrYgBvDIGHxX4TCwuGeo2VELt0H5nYDxnQ0OBVGpGiyZKykumoy1Vt2kzA2zjceMfI48WNFPmjnry/BUC7og3d1UeZEpemysVZSGBsVIIYHpadT7P4RcL/AJrE9gqD9FSPvsxHvZdx+5hOdRFhG5G7/wCotD/Lo33HA8ipH6R/aDCn/paAjVEpt6AA/Ay/A1FxmCD1iFX6Qu/QBKma1+lhaLAY8YzDYobAs6IP4cgyTiTkkl7M7XGNt+6POrn73wjwX6U9I86vUOb00esVEuNZnYlrkAcje3hrr+kNTDuR2nJ7r2H+0CB4kBVYWtZW+UWPZz5ba6oIx7WCN0dPibH5wkwfFJnpEcymnja4+Mtw1XOiv1APqIr6GT5/JOczj6mbGFfuUF9XdifgizpVOk5qqP8AO1e+lRt4XqD5gyjM/kZ26NXlRrYZYsVRuNpPDjSXVE0nAjYZhq7IeohmGxQOt/1kq9LugVXDkG66GP2QdFhqsMDzl8NjSujafKadPiI6yKYGqziUs8DGKBMtNcGKyUiVR4HWePWxAF+cz3xEEmw4RZVqcoMzyp63fM3iXEcqNl3sdf0lsYc0LKSSbDkxS58u7fAQ4VQqsxNrA69ABcn0nM8GViMx+1tNviQzZKI3cgH8C9pz8h5zWjjjCKSPNZM8s2V34C+CIcmc7uS57gfdHkLRcQ4fTrkhxfJaxBIIvqdvKH00sBMpsUBUdepGv3QALyEtzbIlLakT4TgCjFhYIosiKLC53ZvvG3M33mg9cXseXw75V9ZULYdNiCCeu41MGo63PXaTt3csWefbSRpPSSqAKtNKhGzkWf8AqGsofguGF3+r536PUZr912MhSxNt9ppKCbG9hzHWUyhR04s+5HC+0nFMQR9E1H6vSB0RR2W8XGh8BOfWoRsSL9CRPVsQgYEEAg7gi4PiDOP437NG5egunNBy70vv4ektxyjVUE7buzl4pb9Uqf8Ajf8Aob9IpdcROT1oPpeZWJe4q9yW/q//ACG03uszU1R2+84HkCP1nPFVZVmnupGrh9UUd0F4U3ZdOaOw8icw+fwl2AbsEdGYejGALUyYlhydR6gafmIJXaJcqSl+jVX85zvE1yYxG+/SK370e9vRzOi5+MxvaakciVRvRcOfwEFX9Ac38soyxuLR2aaW3ImG0NrwiCYZ7gHuEJEzkbbKqq6yo05fUjqt4yIM6ph7wWpQI2m6acpfDSUwML6VhJtj2Gk0nwl5Q2Dk2BntimMqZyecMqUrQd0uYbqJqwZzfSY/FjmZKa7u3wG/zE36qWEzMFRz1nqHZBkXxOrH5DyMt06c8iRy63KsWBtmlhqYUBegHwh3C6eZmrHYjIn4VJu38zXPgBM+sCbIN237l5nz29ZvYZMqhRpYWmvkPMYLVt+QlTOawINTEsfsh3PjY2Am9VqZVY9FJ9BeAezuHsmc/alcXti2Xv5mkauIQFXYi+VbDvdvd9LXgvD1FsrEXPImx8uomljEyIn8RZz42FvgZT9XUr2luT1lUZ8DTx/MvsD1cN2gFbbUnQhennJphbnV2Pfma/wMvSkFGVQAOkuprByY0cavoHOHcEBSXBIFmOuvRv1lzUSpysLHofy6wnDntp+JfmIdx6krZAwB946+Uqlke5I6o4Vtcl4MrIe/1ikfqq9D/W36xR7KufYGo1OzB0FqB/Hf/fB2qkJpL+G9uk6c9bTocaTf3M+M90kvsGcP0NQdHb4gGZ3GU7at3W8xtNLDWsWH2rMfGwg3FKdxFg/nLcqbxfgIwGKzoDzGh7jCGQEEMLgggjqDuJiYAMj3+yd/1m4usTJBJ8FmnyOUee0YvDVKM1Fj7h7JP2qZ9w+mh71M1QIPxTDEgVEHbS5sPtofeTvPMd475LDYgOoYG4IBvMzLDbI9Bp8u+P3RNtpBHljSrnERewlXlgEFvEMTaSQgplECrvIVsWeQ/aBVKh5mQNRViDKUTnLUQmQxLhVJOlorYy4A8c591RdibAd5/IflLqOHVEHMC/i7Hn5m/rHwGEIvWqjKLdlTvl6npfTTp4wrDoXbO3uD3R+c1dJi2R3PtnnPimf1ZqEekLC4axzMLu2p/hHITStykaSHVjufgOUd2l8nbOOK2q2ZnGcTZcg3fs+v7Xmth6YREU6Dsr/UQPzmFQ/xcRpqtPTxY2Lemg9ZvV7tUpINy6sfwocx+QkT4VFmJPdZp8fXSmB/EP8AjBLQvij5nAI9waeLW1+AgZM54fSkdWWt7Y6ywyCDnHteSxF0X8PS9VPxX9NZocZbtKOg+Z/aUcLT/EHcCfh+8firf4h7gP7+Mok7yHXBbcL+7A7RRvKKWlJzre55S/gnvHwjxTvl9LMbF/IvwH4T82/5GRxu0aKc8fqO2f8AGVJsfA/KF4T3F8BFFJyC4OwgbzB4V9r/AOR/+bRRTg1Pg2tF2zVlTbxRTlNBiaUVto0UkEUHaVPFFIGJLtAcV/qJ+NfmIooR7In9LDPaD3PX5iFUvdXyiim5H6EeSyfyMNbaCVYooqGmZXstu/46n/Izfwn/ALyn+B/yiikZen+C3F9f7D+Kf6jeC/8AEQTkYopTj+lF2b62WrtJJvGigyEaPC/9T+U/lKuJf6jeXyEUUo/3Drf8P7Booopac5//2Q==">
	</a>
	<c:if test="${empty currentUser }">
		<a href="${pageContext.request.contextPath }/login">로그인하기</a>	
	</c:if>
	<c:if test="${not empty currentUser }">
		${currentUser.name }님 안녕하세요.<br>
		<a href="${pageContext.request.contextPath }/logout">로그아웃</a>	
	</c:if>
	<div align="center">
		<table border="1" width="60%">
			<tr>
				<th>번호</th>
				<td>${boardVO.no}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${boardVO.title}</td>
			</tr>
			<tr>
				<th>지은이</th>
				<td>${boardVO.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${boardVO.regDate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardVO.content}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardVO.count}</td>
			</tr>
		</table>
	</div>
</body>
</html>