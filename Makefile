add:
	git status
	read -p "Digite o nome do arquivo que deseja adicionar: " file; git add $$file

addAll:
	git add .

pull:
	git pull

commit:
	$(MAKE) pull
	read -p "Digite 'all' para adicionar todos os arquivos ou 'add' para um especifico: " option; \
	if [ $$option = "all" ]; then  \
	    $(MAKE) addAll; \
    elif [ $$option = "add" ]; then \
    	$(MAKE) add; \
    else \
    	echo "Opção incorreta"; \
	fi

	read -p "Escreva o texto do commit: " text; git commit -m "$$text"
	git push

log:
	$(MAKE) pull
	git log --oneline

reset:
	$(MAKE) log
	read -p "Digite o hash do commit: " hash; git reset --soft $$hash

branch:
	read -p "Digite o nome da branch: " name; \
	git checkout -b $$name; \
	git push -u origin $$name;

deleteBranch:
	read -p "Digite o nome da branch que vc quer deletar: " name; \
	git checkout main; \
	git branch -D $$name; \
	git push;