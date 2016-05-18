create table tb_book                 
(
  bookId int primary key auto_increment,     
  superTypeId int,                                        
  subTypeId int,                                            
  bookName varchar(200),						
  ISBN varchar(20),                           
  introduce text,                                                     
  price float,                                                     
  nowPrice float,                                          
  picture varchar(200),  						
  pages int,									
  publisher varchar(40),						
  author varchar(20),                                  
  inTime timestamp,                                            
  newBooks int,                                          
  saleBooks int,                                               
  hostBooks int,                                
  specialBooks int,                            
  bookNum  int,                                               
  foreign key(subTypeId ) references tb_subType(subTypeId),
  foreign key(superTypeId) references tb_superType (superTypeId)
 );
 
 
 insert into tb_book values(null,1,1,'Orhans Inheritance','1616203749','Places and things stay with us, and sometimes we stay with them.Remembering the past can be a tricky business and for those who experienced dark times in history the memories they may most want to forget are the very ones that future generations insist that they share. Orhans Inheritance begins in a small village in Turkey, with the death of a patriarch, Kemal, who bequeaths the family home to a woman his heirs have never heard of. Kemals grandson, Orhan, finds her across the world in a home for elderly Armenians and their meeting leads to a long buried account of two people deeply in love, torn apart by war and terrible sacrifice. Aline Ohanesian��s debut novel is rich in emotion and its roots run deep and wide, tapping into a largely neglected time in Turkish history, spanning decades, and honoring the resilience of the human spirit',26,13.5,'images/book1.jpg',320,'Algonquin Books',' Aline Ohanesian',null,1,1,0,0,120); 
 insert into tb_book values(null,1,1,'H is for Hawk','0802123414','When Helen Macdonalds father died suddenly on a London street, she was devastated. An experienced falconer��Helen had been captivated by hawks since childhood��she never before been tempted to train one of the most vicious predators, the goshawk. But in her grief, she saw that the goshawks fierce and feral temperament mirrored her own. Resolving to purchase and raise the deadly creature as a means to cope with her loss, she adopted Mabel, and turned to the guidance of The Once and Future King author T.H. Whites chronicle The Goshawk to begin her challenging endeavor. Projecting herself "in the hawks wild mind to tame her" tested the limits of Macdonalds humanity and changed her life.',26,15.6,'images/book5.jpg',230,' Grove Press','Helen Macdonald',null,0,1,0,1,120); 
 insert into tb_book values(null,1,1,'The Wonder Garden','0802123554','Lauren Acamporas debut novel is a series of linked stories set in the affluent suburbs. The characters in one story might turn up in one farther along in the book, but each story stands on its own��taken as a complete novel, The Wonder Garden has an alchemical effect thats greater than the sum of its parts. Working with precise language and metaphor, she peels back the suburban veneer, highlighting our wants and our weirdness, taking characters that might seem stock if you saw them in the local Whole Foods and drawing out their individual eccentricities. It is inevitable that some will generalize Acamporas novel as dark or even weird, and some of the individual stories are; she is working in the same milieu as Cheever, examining how relationships are tested by the particular pace and expectations of suburbia, and exploring the unique individuals relationship to a place that, on the surface, demands homogeneity. Her characters are far from normal, even if they exist in a world that seems that way. But maybe that is normal. This is a wonderful debut by a striking talent',24,12.5,'images/book3.jpg',412,'Grove Press','Lauren Acampora',null,0,1,1,1,120); 
 insert into tb_book values(null,1,1,'Between You & Me: Confessions of a Comma Queen','978-0393240184','Once upon a time, a couple or few decades ago, most American boys and girls in grade school were taught grammar and punctuation; we learned, for example, that ��i�� came before ��e,�� except after ��c�� (except sometimes, but never mind) and that the verb ��to be�� was ��like an equal sign,�� which meant that you used the nominative case (have I lost you yet?) on both sides of it. (��It is I,�� in other words, is the correct, if dowdy, response to ��Whos there?��) Some of us were even taught to diagram sentences; some had parents who corrected us at the family dinner table. (I can still hear my father pressing the subjunctive upon me. ��If I WERE,�� he��d bellow, when I allowed as how thered be later curfews if I ��was�� in charge.) Whether they retained the lessons or not, most people probably dont wax romantic about the grammar lessons or teachers of yore.',24,17.1,'images/book9.jpg',502,'W. W. Norton & Company','Mary Norris',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'An Ember in the Ashes','1595148035','��This novel is a harrowing, haunting reminder of what it means to be human��and how hope might be kindled in the midst of oppression and fear.�� ��The Washington Post',19,11.8,'images/1.jpg',128,'Razorbill','Sabaa Tahir',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'Dead Wake: The Last Crossing of the Lusitania','0307408868','It is a story that many of us think we know but dont, and Erik Larson tells it thrillingly, switching between hunter and hunted while painting a larger portrait of America at the height of the Progressive Era. Full of glamour and suspense, Dead Wake brings to life a cast of evocative characters, from famed Boston bookseller Charles Lauriat to pioneering female architect Theodate Pope to President Woodrow Wilson, a man lost to grief, dreading the widening war but also captivated by the prospect of new love.',28,15.4,'images/7.jpg',128,'Crown','Erik Larson',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'Ghettoside: A True Story of Murder in America','97875317239657','Here is the kaleidoscopic story of the quintessential, but mostly ignored, American murder��a ��ghettoside�� killing, one young black man slaying another��and a brilliant and driven cadre of detectives whose creed is to pursue justice for forgotten victims at all costs. Ghettoside is a fast-paced narrative of a devastating crime, an intimate portrait of detectives and a community bonded in tragedy, and a surprising new lens into the great subject of why murder happens in our cities��and how the epidemic of killings might yet be stopped',28,14.9,'images/8.jpg',128,' Spiegel & Grau ',' Jill Leovy',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'All the Old Knives','1455599891','All the Old Knives has a disarmingly quiet start, but good spy novels are like good spies: they draw you in, earn your trust, and then grab hold with both hands. In Vienna during the mid-2000s Henry and Celia were intelligence agents and lovers who witnessed a terrorist hijacking as it took a shocking turn. Five years later, the two meet over dinner at a restaurant in Carmel-by-the-Sea where Celia now lives as a civilian, to recall the events of the past. As the remembrances overlap with the present moment, tension mounts and questions of who did what to whom, and why, become increasingly urgent. By the last 100 pages Steinhauers hook is firmly embedded and its hard not to race to the finish. And the ending? I can sum it up in one word--brilliant',23.9,12.44,'images/9.jpg',128,' Minotaur Books',' Olen Steinhauer',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'Saint Mazie','9787531723951','Meet Mazie Phillips: big-hearted and bawdy, shes the truth-telling proprietress of The Venice, the famed New York City movie theater. Its the Jazz Age, with romance and booze aplenty--even when Prohibition kicks in--and Mazie never turns down a night on the town. But her high spirits mask a childhood rooted in poverty, and her diary, always close at hand, holds her dearest secrets.When the Great Depression hits, Mazies life is on the brink of transformation. Addicts and bums roam the Bowery; homelessness is rampant. If Mazie wont help them, then who? When she opens the doors of The Venice to those in need, this ticket taking, fun-time girl becomes the beating heart of the Lower East Side, and in defining one neighborhood helps define the city.Then, more than ninety years after Mazie began her diary, its discovered by a documentarian in search of a good story. Who was Mazie Phillips, really? A chorus of voices from the past and present fill in some of the mysterious blanks of her adventurous life.Inspired by the life of a woman who was profiled in Joseph Mitchells classic Up in the Old Hotel, SAINT MAZIE is infused with Jami Attenbergs signature wit, bravery, and heart. Mazies rise to "sainthood"--and her irrepressible spirit--is unforgettable.',25,13.6,'images/2.jpg',128,'Grand Central Publishing','Jami Attenberg',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'The Sympathizer','0802123457','It is April 1975, and Saigon is in chaos. At his villa, a general of the South Vietnamese army is drinking whiskey and, with the help of his trusted captain, drawing up a list of those who will be given passage aboard the last flights out of the country. The general and his compatriots start a new life in Los Angeles, unaware that one among their number, the captain, is secretly observing and reporting on the group to a higher-up in the Viet Cong. The Sympathizer is the story of this captain: a man brought up by an absent French father and a poor Vietnamese mother, a man who went to university in America, but returned to Vietnam to fight for the Communist cause. A gripping spy novel, an astute exploration of extreme politics, and a moving love story, The Sympathizer explores a life between two worlds and examines the legacy of the Vietnam War in literature, film, and the wars we fight today.',25,13.6,'images/3.jpg',128,'Grove Press','Viet Thanh Nguyen',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'The Wright Brothers','97875317239512','Most people recognize the famous black-and-white photo of the Wright brothers on a winter day in 1903, in a remote spot called Kitty Hawk, when they secured their place in history as the first to fly a motor-powered airplane. That brilliant moment is the cornerstone of the new masterful book by Pulitzer Prize-winning historian David McCullough, who brings his deft touch with language and his eye for humanizing details to the unusually close relationship between a pair of brothers from Dayton, Ohio, who changed aviation history. Bicycle shop owners by day, Wilbur and Orville taught themselves flight theory through correspondence with the Smithsonian and other experts. But the brothers soon realized that theory was no match for practical testing, and they repeatedly risked life and limb in pursuit of their goal��including when Orville fractured a leg and four ribs in a 75-foot plunge to the ground. McCulloughs narration of ventures such as this��their famous first flight at Kitty Hawk; the flight in Le Mans, France that propelled the brothers to international fame; the protracted patent battles back at home; and the early death of elder brother Wilbur��will immerse readers in the lives of the Wright family. Like other great biographies before it, The Wright Brothers tells the story about the individuals behind the great moments in history, while never sacrificing beauty in language and reverence in tone',30,18,'images/4.jpg',128,'Simon & Schuster','The Wright Brothers',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'Green on Blue','1476778558','Green on Blue unravels the complexities of the Afghan war, then dissolves it all into the brutal heartache of reality �C where home is a battlefield, fighting is a job, vengeance is a moral right, and war is ��a racket it had no sides. Each was the same as the other.�� Aziz, an Afghan boy at the beginning of the novel, has lost nearly everything: Taliban forces killed his parents, and his older brother is left crippled when U.S. forces clash with militant ones. Alone, in need of money and seeking revenge, he enlists in the Special Lashkar, a militia funded by Americans to fight local insurgents. Aziz rises through the ranks, learns to kill, and discovers the nefarious profiteering, oppression and cultural beliefs that contrive this never ending war. A decorated Afghan and Iraq war veteran, Elliot Ackermans empathetic portrayal of individuals, factions, and the reasons they fight is fierce and haunting. With crisp, uncompromising prose, Green on Blue joins the canon of contemporary war literature and leaves you breathless',25,13.1,'images/5.jpg',128,'Scribner','Elliot Ackerman',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'The Nightingale','0312577222','Kristin Hannah is a popular thriller writer with legions of fans, but her latest novel, The Nightingale, soars to new heights (sorry) and will earn her even more ecstatic readers. Both a weeper and a thinker, the book tells the story of two French sisters �C one in Paris, one in the countryside �C during WWII; each is crippled by the death of their beloved mother and cavalier abandonment of their father; each plays a part in the French underground; each finds a way to love and forgive. If this sounds sudsy. . . well, it is, a little. . . but a melodrama that combines historical accuracy (Hannah has said her inspiration for Isabelle was the real life story of a woman who led downed Allied soldiers on foot over the Pyrenees) and social or political activism is a hard one to resist. Even better to keep you turning pages: the central conceit works �C the book is narrated by one of the sisters in the present, though you really dont know until the very end which sister it is. Fast-paced, detailed, and full of romance (both the sexual/interpersonal kind and the larger, trickier romance of history and war), this novel is destined to land (sorry, again) on the top of best sellers lists and night tables everywhere',27.9,16.1,'images/6.jpg',128,'St. Martins Press',' Kristin Hannah',null,1,1,1,1,120); 
 