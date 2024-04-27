import pygame
from pygame.locals import *
import tkinter as tk
import tkinter as tk
from proj.myPoint import Point
from tkinter import messagebox


class OrganismMap:
    def __init__(self, width, height, organisms, world):
        self.width = width
        self.height = height
        self.organisms = organisms
        self.world = world
        pygame.init()

        self.cell_width = 800 // width
        self.cell_height = 600 // height

       # self.window_width = self.width * self.cell_width
        #self.window_height = self.height * self.cell_height

        #self.window = pygame.display.set_mode((self.window_width, self.window_height))
        self.window = pygame.display.set_mode((800, 600))
        pygame.display.set_caption("Organism Map")

    def setSize(self, x, y):
        self.width = x
        self.height = y
        self.cell_width = 800 // self.width
        self.cell_height = 600 // self.height
    def draw(self):
        for x in range(self.width):
            for y in range(self.height):

                organism = self.organisms[x][y]
                cell_x = x * self.cell_width
                cell_y = y * self.cell_height

                color = self.organisms[x][y].getColor()
                pygame.draw.rect(self.window, color, (cell_x, cell_y, self.cell_width, self.cell_height))


        pygame.display.flip()

    def run(self):
        running = True

        while running:

            key_pressed = False
            while not key_pressed:
                for event in pygame.event.get():
                    if event.type == pygame.KEYDOWN:
                        key_pressed = True
            keys = pygame.key.get_pressed()
            if keys[pygame.K_UP]:
                self.world.setTemp(1)
                self.world.nextTurn()
            elif keys[pygame.K_RIGHT]:
                self.world.setTemp(3)
                self.world.nextTurn()
            elif keys[pygame.K_LEFT]:
                self.world.setTemp(2)
                self.world.nextTurn()
            elif keys[pygame.K_DOWN]:
                self.world.setTemp(4)
                self.world.nextTurn()
            elif keys[pygame.K_s]:
                self.world.setTemp(5)
                self.world.nextTurn()
            elif keys[pygame.K_q]:
                running = False
            elif keys[pygame.K_g]:
                self.world.save()
                self.world.nextTurn()
            elif keys[pygame.K_l]:
                self.world.load_the_game()
                self.world.nextTurn()
            elif keys[pygame.K_SPACE]:
                self.func()
                #print (self.getMousePos())
                self.world.nextTurn()
            else:
                self.world.setTemp(0)
                self.world.nextTurn()
            # Обработка событий клавиатуры



            self.draw()

            # Ожидание события

    def getMousePos(self):
        mouse_x, mouse_y = pygame.mouse.get_pos()
        # Вычисляем позицию ячейки на основе позиции мыши и размеров ячейки
        cell_x = mouse_x // self.cell_width
        cell_y = mouse_y // self.cell_height
        return cell_x, cell_y
    def func(self):
        mouse_x, mouse_y = self.getMousePos()
        options = ["Sheep", "Wolf", "Turtle", "Fox", "Antelope", "Grass", "Dandelion", "Guarana", "Wolfberries",
                   "Heracleum", "CyberSheep"]

        pygame.init()
        screen_width, screen_height = 800, 600
        screen = pygame.display.set_mode((screen_width, screen_height))
        pygame.display.set_caption("Options")

        font = pygame.font.Font(None, 36)
        clock = pygame.time.Clock()

        option_height = 25
        #options_per_page = screen_height // option_height
        #num_pages = (len(options) - 1) // options_per_page + 1
        #current_page = 0

        while True:
            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    return
                elif event.type == pygame.MOUSEBUTTONDOWN:
                    if event.button == 1:  # Left mouse button
                        mouse_pos = pygame.mouse.get_pos()
                        if 250 <= mouse_pos[0] <= 600 and 100 <= mouse_pos[1] <= 800:
                            option_index = (mouse_pos[1] - 100) // option_height
                            selected_option_index = option_index
                            if selected_option_index < len(options):
                                need_typ = selected_option_index + 1
                                print(need_typ)
                                #world.create_organism(need_typ, (x, y))
                                #pygame.quit()
                                #print(mouse_x, mouse_y)
                                self.world.createOrganizm(need_typ, Point(mouse_x, mouse_y))
                                return
            screen.fill((255, 255, 255))
            start_index = 0
            end_index = min(start_index + 25, len(options))

            for i, option_index in enumerate(range(start_index, end_index)):
                option = options[option_index]
                text = font.render(option, True, (0, 0, 0))
                rect = text.get_rect()
                rect.center = (400, 125 + (i * option_height))
                pygame.draw.rect(screen, (200, 200, 200), rect)
                screen.blit(text, rect)



            pygame.display.flip()
            clock.tick



class dialog():
    def __init__(self):
        self.selected_option = None

    def show_option_window(self):
        def get_selected_option():
            self.selected_option = var.get()
            root.destroy()  # Закрываем окно после выбора

        root = tk.Tk()

        # Создание переменной для хранения выбранной опции
        var = tk.StringVar()

        # Создание виджета Radiobutton для каждой опции
        option1 = tk.Radiobutton(root, text="Опция 1", variable=var, value="Опция 1")
        option2 = tk.Radiobutton(root, text="Опция 2", variable=var, value="Опция 2")
        option3 = tk.Radiobutton(root, text="Опция 3", variable=var, value="Опция 3")

        # Размещение виджетов на окне
        option1.pack()
        option2.pack()
        option3.pack()

        # Создание кнопки для получения выбранной опции
        button = tk.Button(root, text="Получить выбранную опцию", command=get_selected_option)
        button.pack()

        root.mainloop()




